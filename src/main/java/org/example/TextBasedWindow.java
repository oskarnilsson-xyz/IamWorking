package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TextBasedWindow extends JFrame {

    private JPanel panel1;
    private JTextArea mainTextArea;
    private JButton goToSettingsButton;
    private JButton uploadFileButton;
    private JButton enterTextButton;

    String textToLoad = "\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"";

    char[] keyInputs = "abcdefghijklmnopqrstuvwxyzåäö".toCharArray(); // List över de tangenter vi vill ska generera kod/text i vårat programm
    int generationSpeed = 10; // Antalet tecken som ska generaras vid varje knapptryckning
    int count = 0; // Vi behöver något som räknar hur mycket text vi redan skrivit ut så vi kan fortsätta att generera text där vi slutade


    public TextBasedWindow() {
        setContentPane(panel1);
        setTitle("Code typer");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Imitate settings
        mainTextArea.setForeground(Color.blue);
        mainTextArea.setBackground(Color.lightGray);

        goToSettingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("In the future, this button will take you to settings.");
            }
        });
        uploadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("This button should allow you to upload a file which we will generate text from.");
            }
        });
        enterTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Should it be an option to just enter a copied text?");
            }
        });

        // KeyListener, to listen when we press keys on our keyboard
        mainTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) { // e är våran knapptryckning, e.getKeyChar använder vi för att se tecken det är på tangenten vi tryckte på.
                /* Nedan sker följande:
                   Vi gör om våran array of char(characters) till en sträng.
                   Sedan letar vi efter vilken plats(index) i våran sträng som tecknet för våran knapptryckning har.
                   Om den inte hittar tecknet i våran sträng så returnerar den -1, så vi behöver bara kolla resultat är lika med eller större än index 0.
                   På så sätt kan vi generera text vid knapptryckning endast med de tecken som vi vill ska vara giltiga, vilket vi definerar i keyInputs
                 */

                if (new String(keyInputs).indexOf(e.getKeyChar()) >= 0) {
                    System.out.println(e.getKeyChar());
                    count++;
                    if(count * generationSpeed >= textToLoad.length()) { // If the number of characters that should be written is greater than our total text length, restart from 0
                        count=0;
                    }
                    mainTextArea.setText(textToLoad.substring(0, (count*10)));
                }
            }
        });
    }
}
