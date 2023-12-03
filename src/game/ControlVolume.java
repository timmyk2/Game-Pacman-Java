/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author acer
 */
public class ControlVolume extends Game {
    private JSlider volumeSlider;
    
    private BackgroundMusicPlayer musicPlayer;
    
    public ControlVolume(BackgroundMusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
        

        JLabel titleLabel = new JLabel("Volume Control");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel volumeLabel = new JLabel("Volume:");

        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        volumeSlider.setMajorTickSpacing(10);
        volumeSlider.setMinorTickSpacing(1);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);

        volumeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int volumeValue = volumeSlider.getValue();
                float volume = volumeValue / 100.0f;
                musicPlayer.setVolume(volume);
            }
        });

        JButton backButton = new JButton("Back");
    backButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Hiển thị lại JFrame Menu (hoặc class Menu) đã được chuyển tham chiếu từ constructor
        SwingUtilities.invokeLater(() -> {
             setVisible(false);
                                   
             
        });
    }
});

        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(volumeLabel);
        centerPanel.add(volumeSlider);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BackgroundMusicPlayer musicPlayer = new BackgroundMusicPlayer();
            musicPlayer.playMusic("Music/mop.wav");

            new ControlVolume(musicPlayer);
        });
    }
}
