package offline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Chat extends JFrame {

    private JTextArea textArea = new JTextArea();
    private JPanel chatPanel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JTextField textInput = new JTextField();
    private JLabel textInputLabel = new JLabel("Your message : ");
    private final JButton sendButton = new JButton("Send");
    private final ActionListener listener = event -> {
        sendMessage(textInput.getText() + "\n");
        textInput.setText("");
    };

    public Chat(){
        this.setTitle("Chat");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new FlowLayout());
        textArea.setEditable(false);
        chatPanel.setBackground(Color.WHITE);
        chatPanel.setPreferredSize(new Dimension(490, 490));
        scrollPane.setPreferredSize(new Dimension(450, 350));
        chatPanel.add(scrollPane);
        textInput.setPreferredSize(new Dimension(150, 25));
        chatPanel.add(textInputLabel);
        chatPanel.add(textInput);

        textInput.addActionListener(listener);
        sendButton.addActionListener(listener);
        chatPanel.add(sendButton);
        this.add(chatPanel);
        this.setVisible(true);
    }


    public void sendMessage(String message){
        textArea.append(message);
    }

}
