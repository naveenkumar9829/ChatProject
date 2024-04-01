
package ChattingApplicationProject;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.text.*;

import javax.swing.border.*;
import java.net.*;
import java.io.*;

public class Client implements ActionListener {

	JTextField text;
	static JPanel a1;
	static Box vertical = Box.createVerticalBox();

	static JFrame f = new JFrame();

	static DataOutputStream dout;

	Client() {
		f.setLayout(null);

		JPanel p1 = new JPanel();
//		JScrollPane scrollPane = new JScrollPane(p1);
//		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//		scrollPane.setBounds(50, 30, 300, 50);
//
//		JPanel contentPane = new JPanel(null);
//		contentPane.setPreferredSize(new Dimension(500, 400));
//		contentPane.add(scrollPane);

		p1.setBackground(new Color(7, 94, 84));
		p1.setBounds(0, 0, 450, 60);
		p1.setLayout(null);

//		f.setContentPane(contentPane);
//		f.pack();
//		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		f.setVisible(true);

		f.add(p1);

		// ..............

		try {
			String icons3Png = "C:/Users/shatr/OneDrive/Desktop/HIMT_Project/HIMT_Project_Wrokspace/ChattingApplication/src/icons/3.png";
//				ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
			ImageIcon i1 = new ImageIcon(icons3Png);
			Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel back = new JLabel(i3);
			back.setBounds(5, 20, 25, 25);
			p1.add(back);

			back.addMouseListener(new MouseAdapter() {
				public void mouseClicKed(MouseEvent ae) {
					System.exit(0);
				}
			});

			String icons2Png = "C:/Users/shatr/OneDrive/Desktop/HIMT_Project/HIMT_Project_Wrokspace/ChattingApplication/src/icons/2.png";
//				ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
			ImageIcon i4 = new ImageIcon(icons2Png);
			Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			ImageIcon i6 = new ImageIcon(i5);
			JLabel profile = new JLabel(i6);
			profile.setBounds(40, 10, 50, 50);
			p1.add(profile);

			String videoPng = "C:/Users/shatr/OneDrive/Desktop/HIMT_Project/HIMT_Project_Wrokspace/ChattingApplication/src/icons/video.png";
//				ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
			ImageIcon i7 = new ImageIcon(videoPng);
			Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
			ImageIcon i9 = new ImageIcon(i8);
			JLabel video = new JLabel(i9);
			video.setBounds(300, 20, 30, 30);
			p1.add(video);

			String phonePng = "C:/Users/shatr/OneDrive/Desktop/HIMT_Project/HIMT_Project_Wrokspace/ChattingApplication/src/icons/phone.png";
//				ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
			ImageIcon i10 = new ImageIcon(phonePng);
			Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
			ImageIcon i12 = new ImageIcon(i11);
			JLabel phone = new JLabel(i12);
			phone.setBounds(360, 20, 35, 30);
			p1.add(phone);

			String icons13Png = "C:/Users/shatr/OneDrive/Desktop/HIMT_Project/HIMT_Project_Wrokspace/ChattingApplication/src/icons/3icon.png";
//				ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icons.png"));
			ImageIcon i13 = new ImageIcon(icons13Png);
			Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
			ImageIcon i15 = new ImageIcon(i14);
			JLabel morevert = new JLabel(i15);
			morevert.setBounds(420, 20, 10, 25);
			p1.add(morevert);

			JLabel name = new JLabel("Amit");
			name.setBounds(110, 15, 100, 18);
			name.setForeground(Color.WHITE);
			name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
			p1.add(name);

			JLabel status = new JLabel("Active Now");
			status.setBounds(110, 35, 100, 18);
			status.setForeground(Color.WHITE);
			status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
			p1.add(status);

		} catch (Exception e) {
			System.out.println("Execption while setting image in client " + e);
		}

		// ************

		a1 = new JPanel();
		a1.setBounds(5, 75, 440, 570);
		f.add(a1);

		text = new JTextField();
		text.setBounds(5, 655, 310, 40);
		text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		f.add(text);

		JButton send = new JButton("Send");
		send.setBounds(320, 655, 123, 40);
		send.setBackground(new Color(7, 94, 84));
		send.setForeground(Color.WHITE);
		send.addActionListener(this);
		send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		f.add(send);

		// ...............

		f.setSize(450, 700);
		f.setLocation(800, 50);
		f.setUndecorated(true);
		f.getContentPane().setBackground(Color.WHITE);

		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		try {
			String out = text.getText();

			JPanel p2 = formatLable(out);

			JScrollPane scrollPane = new JScrollPane(p2);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(50, 30, 300, 50);

			a1.setLayout(new BorderLayout());

			JPanel right = new JPanel(new BorderLayout());
			JScrollPane scrollPane1 = new JScrollPane(right);
			scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			scrollPane1.setBounds(50, 30, 300, 50);
			right.add(p2, BorderLayout.LINE_END);

			vertical.add(right);
			vertical.add(Box.createVerticalStrut(15));

			a1.add(vertical, BorderLayout.PAGE_START);

			dout.writeUTF(out);

			text.setText("");
			f.repaint();
			f.invalidate();
			f.validate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static JPanel formatLable(String out) {
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(50, 30, 300, 50);

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel output = new JLabel("<html><p style= \"width: 150px\">" + out + " </p></html>");

		output.setFont(new Font("Tahoma", Font.PLAIN, 16));
		output.setBackground(new Color(37, 211, 102));
		output.setOpaque(true);
		output.setBorder(new EmptyBorder(15, 15, 15, 50));

		panel.add(output);

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		JLabel time = new JLabel();
		time.setText(sdf.format(cal.getTime()));
		panel.add(time);

		return panel;
	}

	public static void main(String[] args) {

		new Client();

		try {
			Socket s = new Socket("127.0.0.1", 8080);
			DataInputStream din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			while (true) {

				a1.setLayout(new BorderLayout());
				String msg = din.readUTF();
				JPanel panel = formatLable(msg);
				JScrollPane scrollPane = new JScrollPane(panel);
				scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(50, 30, 300, 50);

				JPanel lift = new JPanel(new BorderLayout());
				JScrollPane scrollPane1 = new JScrollPane(lift);
				scrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				scrollPane1.setBounds(50, 30, 300, 50);

				lift.setAutoscrolls(true);
				lift.add(panel, BorderLayout.LINE_START);
				vertical.add(lift);

				vertical.add(Box.createVerticalStrut(15));
				a1.add(vertical, BorderLayout.PAGE_START);

				f.validate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
