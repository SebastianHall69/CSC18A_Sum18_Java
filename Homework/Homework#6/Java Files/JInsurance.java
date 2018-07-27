//No Comments This Time

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JInsurance extends JFrame implements ItemListener, ActionListener 
{
    //Data field declaration
    final int WIDTH = 400;
    final int HEIGHT = 250;
    final int HMO_PRICE = 200;
    final int PPO_PRICE = 600;
    final int DENTAL_PRICE = 75;
    final int VISION_PRICE = 20;
    int totalPrice = HMO_PRICE;
    JCheckBox hmo = new JCheckBox
        ("HMO", true);
    JCheckBox ppo = new JCheckBox
        ("PPO", false);
    ButtonGroup group = new ButtonGroup();
    JCheckBox dental = new JCheckBox("Dental Insurance");
    JCheckBox vision = new JCheckBox("Vision Insurance");
    JTextField totPrice = new JTextField(8);
    JTextField options = new JTextField(12);
    JLabel header = new JLabel("Insurance Options");
    JLabel message = new JLabel("");
    JButton button = new JButton("Buy Insurance");
        
    //Main method
    public static void main(String [] args)
    {
        JInsurance frame = new JInsurance();
        frame.setVisible(true);
    }
        
    //Public methods
    JInsurance()
    {
        super("Health Insurance");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        group.add(hmo);
        group.add(ppo);
        setLayout(new FlowLayout());
        totPrice.setText("Total $" + totalPrice);
        totPrice.setEditable(false);
        options.setEditable(false);
        hmo.addItemListener(this);
        ppo.addItemListener(this);
        dental.addItemListener(this);
        vision.addItemListener(this);
        button.addActionListener(this);
        add(header);
        add(hmo);
        add(ppo);
        add(dental);
        add(vision);
        add(options);
        add(totPrice);
        add(button);
        add(message);
    }
    @Override
    public void actionPerformed(ActionEvent event)
    {
        message.setText
            ("That button doesn't actually do anything besides this");
    }
    @Override
    public void itemStateChanged(ItemEvent event)
    {
        //Declare variables
        Object source = event.getSource();
        int select = event.getStateChange();
        
        //Change price based on decision
        if(source == hmo)
        {
            if(select == ItemEvent.SELECTED)
            {
                totalPrice += HMO_PRICE;
                options.setText("HMO $" + DENTAL_PRICE);
            }
            else
            {
                totalPrice -= HMO_PRICE;
                options.setText("");
            }
            message.setText("");
        }
        else if(source == ppo)
        {
            if(select == ItemEvent.SELECTED)
            {
                totalPrice += PPO_PRICE;
                options.setText("PPO $" + PPO_PRICE);
            }
            else
            {
                totalPrice -= PPO_PRICE;
                options.setText("");
            }
            message.setText("");
        }
        else if(source == dental)
        {
            if(select == ItemEvent.SELECTED)
            {
                totalPrice += DENTAL_PRICE;
                options.setText("Dental $" + DENTAL_PRICE);
            }
            else
            {
                totalPrice -= DENTAL_PRICE;
                options.setText("");
            }
            message.setText("");
        }
        else if(source == vision)
        {
            if(select == ItemEvent.SELECTED)
            {
                totalPrice += VISION_PRICE;
                options.setText("Vision $" + VISION_PRICE);
            }
            else
            {
                totalPrice -= VISION_PRICE;
                options.setText("");
            }
            message.setText("");
        }
        totPrice.setText("Total $" + totalPrice);
    }
}
