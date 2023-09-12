package Cutomers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;

public class Terms_conditions_customer extends JFrame {
	static String page_detailString = "";
	private JPanel contentPane;
	static boolean checkoruncheck;
	static JCheckBox chckbxNewCheckBox;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Terms_conditions_customer frame = new Terms_conditions_customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Terms_conditions_customer() {
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(180, 0, 464, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 430, 519);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 494);
		panel.add(scrollPane);

		JTextPane txtpnGhgfth = new JTextPane();
		txtpnGhgfth.setFont(new Font("Tahoma", Font.BOLD, 15));
		if(page_detailString.equals("Life Insurance")) {
	
			txtpnGhgfth.setText("TERMS AND CONDITIONS OF LIFE INSURANCE:-\r\n"
					+ "\r\n"
					+ "The main aim of individuals, especially those who are responsible members of a family setup, is to ensure that their dependents are secure in the event that any unforeseen circumstance occurs. Typically, in several Indian homes, there is a concept of patriarchy that still exists and the primary breadwinner of the family is usually a male. Although, women do contribute to household incomes. Still, individuals need assurances that their dependents will be financially secure after their demise. The only way to do this, and save your money at the same time, is to purchase term insurance, which is essentially putting some funds aside to ensure beneficiaries are financially protected. The plan is bought as any other form of insurance and you get a policy with term insurance terms and conditions attached.\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "About Term Insurance Terms and Conditions\r\n"
					+ "\r\n"
					+ "To understand what terms and conditions of term insurance are all about, you should know a little bit about term insurance and its purpose first. In simple terms, term insurance is an insurance policy that a policyholder has, wherein the policyholder pays premiums to the insurance company. These premiums are paid for a period, the given ‘term’. Hence, this policy is held for a given term with a maturity date. In case of the unfortunate demise of the policyholder while the term is in progress, the nominee mentioned on the policy gets a payout to hand over to the beneficiaries mentioned in the policy document. As with any insurance policy, a term plan comes with term insurance conditions that are essentially clauses about what the plan includes and excludes. Since term insurance plans come with a death benefit for beneficiaries, this is the main inclusion condition in the plan. Consequently, before you buy term insurance, it is important to note the inclusions and vital exclusions of the plan.\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "help you if you are a beneficiary or a policyholder.\r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Occurrence of Death by Participation in Riots/Criminal Conduct -\r\n"
					+ "\r\n"
					+ "Plans of term insurance do not provide coverage for the death of the insured policyholder when they are involved in unlawful activities or even riots. The main purpose of term insurance is coverage for accidental and unforeseen deaths. Therefore, any involvement in criminal activity/riots results in claim rejections.\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "Exclusion Terms - Habits and Lifestyle\r\n"
					+ "\r\n"
					+ "Causes of death may be varied and insurers need to be sure that in case of the untimely demise of a policyholder, beneficiaries rightfully deserve death benefits. Before buying any product of life insurance, therefore, insurers insist on information about a policyholder’s habits and lifestyle that could be the potential cause of death. This information is handy to insurers should a death occur due to any of these habits, namely alcohol consumption, smoking, or consuming intoxicants. To put it plainly, policyholders falling within these categories of habits are considered high-risk applicants, relative to those who do not have these lifestyle habits. Consequently, policyholders who have such habits may be able to avail term insurance, but will have to pay higher premiums according to term insurance plan terms and conditions. Additionally, based on this information, insurers may honour or reject a claim in the event of the policyholder's death. The rejection of a claim will almost certainly be the case if the policyholder has held back information regarding lifestyle habits.\r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Terms and Conditions Regarding Other Exclusions\r\n"
					+ "\r\n"
					+ "The main exclusions that make up the terms and conditions of a term plan have been mentioned above. However, there are other clauses that determine whether claims can be rejected or fulfilled. These exclusions are also part of a term plan’s terms and conditions and before buying a plan the following must be attended to carefully:\r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Existing Medical Condition -\r\n"
					+ "\r\n"
					+ "Normally, term insurance plans include a period of waiting in case a policyholder has a pre-existing medical condition. This may be different for various critical health diseases/conditions before the coverage of insurance begins. The waiting period is typically between 3 months-4 years for several term policies in India. Therefore, if the insured person dies as a result of a pre-existing medical disease or condition within the waiting period, then claims made for the death benefit may be rejected by the insurance company.\r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Self-Inflicted Injury/Suicide -\r\n"
					+ "\r\n"
					+ "In the event the insured individual dies by self-inflicted harm/ injury, or suicide, the insurance company may not process the claims made by nominees or beneficiaries. Furthermore, particular insurers do not have ‘death by suicide’ listed in their exclusions. Some term insurance terms and conditions state that in case the insured person dies due to suicide within the initial year of the term insurance plan, then the premiums paid towards the policy will be paid back by the insurance company. Nonetheless, no more compensation is paid out to beneficiaries. It is a good idea to contact the insurer in order to know whether or not plans or policies cover death due to suicide. Understanding the terms and conditions while making claims regarding the same can only help you if you are a beneficiary or a policyholder.\r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Occurrence of Death by Participation in Riots/Criminal Conduct -\r\n"
					+ "\r\n"
					+ "Plans of term insurance do not provide coverage for the death of the insured policyholder when they are involved in unlawful activities or even riots. The main purpose of term insurance is coverage for accidental and unforeseen deaths. Therefore, any involvement in criminal activity/riots results in claim rejections.\r\n"
					+ "");	
			txtpnGhgfth.setEditable(false);
		}
		else if (page_detailString.equals("Home Insurance")) {
			txtpnGhgfth.setText("TERMS AND CONDITIONS OF HOME INSURANCE\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "Sum Insured\r\n"
					+ "\r\n"
					+ "Sum Insured (SI) is the monetary amount shown against each item under your policy document which shall be insurer's maximum liability. In simpler words, it is the maximum amount that your insurer will pay you (if you file a claim) in case your house and/or its contents get lost/damaged due to natural calamities like earthquakes, floods, fire etc. and unfortunate incidents such as theft and burglaries.\r\n"
					+ "\r\n"
					+ "Home Insurance Premium\r\n"
					+ "\r\n"
					+ "Home insurance premium is the amount that you, the insured, have to pay to your insurer in lieu of the financial protection it provides to your house and/or its contents. The premium amount has to be paid annually and is based on the following factors:\r\n"
					+ "\r\n"
					+ "Sum Insured\r\n"
					+ "\r\n"
					+ "Age of your home\r\n"
					+ "\r\n"
					+ "Coverage selected\r\n"
					+ "\r\n"
					+ "Type and amount of risk\r\n"
					+ "\r\n"
					+ "Type of your home\r\n"
					+ "\r\n"
					+ "Location\r\n"
					+ "\r\n"
					+ "Policy Period\r\n"
					+ "\r\n"
					+ "Policy period is the period commencing from policy start date and terminating at midnight on the policy end date as specified in your policy document.\r\n"
					+ "\r\n"
					+ "Loss settlement\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "In the event of loss, there are four ways in which your insurer can settle your home insurance claim:\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "Indemnity basis: This type of loss settlement reimburses you the claim amount after deducting the cost of wear and tear of your property and/or items.\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Reinstatement basis: With this type of loss settlement option, your insurer will replace your damaged (insured) property and/or items with a new one, which is similar to the one damaged.\r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "Agreed Value basis: The reimbursement done by your insurer in this type of loss settlement is as per the value agreed by you at the time of purchasing the policy. An important point to note here is that, this reimbursement will not consider the current market value of your home and/or its contents.\r\n"
					+ "\r\n"
					+ " \r\n"
					+ "\r\n"
					+ "New for Old basis: With this loss settlement option, when an item is damaged beyond repair, your insurer will pay out for the replacement for the same in full.\r\n"
					+ "");
			txtpnGhgfth.setEditable(false);
			
		}
		else if (page_detailString.equals("Vehicle Insurance")) {
				txtpnGhgfth.setText("TERMS AND CONDITIONS FOR VEHICLE INSURANCE:-\r\n"
						+ "\r\n"
						+ "General Exclusions\r\n"
						+ "\r\n"
						+ "Any accidental loss or damage and/or liability caused, sustained or incurred outside the Geographical Area.\r\n"
						+ "\r\n"
						+ " \r\n"
						+ "\r\n"
						+ "Any claim arising out of any contractual liability.\r\n"
						+ "\r\n"
						+ " \r\n"
						+ "\r\n"
						+ "Any accidental loss or damage and/or liability caused, sustained or incurred whilst the vehicle insured herein is\r\n"
						+ "\r\n"
						+ "(a) being used otherwise than in accordance with the limitations as to Use or\r\n"
						+ "\r\n"
						+ "(b) being driven by or is for the purpose of being driven by him/her in the charge of any person other than a Driver as stated in the Driver’s Clause.\r\n"
						+ "\r\n"
						+ " \r\n"
						+ "\r\n"
						+ "(i) Any accidental loss or damage to any property whatsoever or any loss or expense whatsoever resulting or arising there from or any consequential loss\r\n"
						+ "\r\n"
						+ "(ii) any liability of whatsoever nature directly or indirectly caused by or contributed to by or arising from ionising radiations or contamination by radioactivity from any nuclear fuel or from any nuclear waste from the combustion of nuclear fuel. For the purposes of this exception combustion shall include any self sustaining process of nuclear fission.\r\n"
						+ "\r\n"
						+ " \r\n"
						+ "\r\n"
						+ "Any accidental loss or damage or liability directly or indirectly caused by or contributed to by or arising from nuclear weapons material.\r\n"
						+ "\r\n"
						+ " \r\n"
						+ "\r\n"
						+ "Any accidental loss or damage and/or liability directly or indirectly or approximately or remotely occasioned by or contributed to by or traceable to or arising out of or in connection with war, invasion, the act of foreign enemies, hostilities or warlike operations (whether before or after declaration of war) civil war, mutiny rebellion, military or usurped power or by any direct or indirect consequences of any of the said occurrences and in the event of any claim here under the Insured shall prove that the accidental loss or damage and/or liability arose independently of and was in no way connected with or occasioned by or contributed to by or traceable to any of the said occurrences or any consequences thereof and in default of such proof the Company shall not be liable to make any payment in respect of such a claim.\r\n"
						+ "\r\n"
						+ " \r\n"
						+ "\r\n"
						+ "For more details on exclusions, please read sales brochure/policy wordings.\r\n"
						+ "\r\n"
						+ " \r\n"
						+ "\r\n"
						+ "Terms & Conditions\r\n"
						+ "\r\n"
						+ "'No Claim Bonus can not be allowed if policy is not renewed within 90 days of its expiry.\r\n"
						+ "\r\n"
						+ "For break in cases, policy issuance will be post inspection of the vehicle or Two working days from date of receipt of premium.\r\n"
						+ "\r\n"
						+ "‘An insured becomes entitled to NCB only at the renewal of a policy after the expiry of the full duration of 12 months.\r\n"
						+ "\r\n"
						+ "This insurance policy is valid only within India\r\n"
						+ "\r\n"
						+ "Section 41 of the Insurance Act, 1938 as amended by Insurance Laws (Amendment) Act, 2015. (Prohibition of rebates):\r\n"
						+ "\r\n"
						+ "No person shall allow or offer to allow, either directly or indirectly, as an inducement to any person to take out or renew or continue insurance in respect of any kind of risk relating to lives or property in India, any rebate of the whole or part of the commission payable or any rebate of the premium shown on the policy, nor shall any person taking out or renewing or continuing a policy accept any rebate, except such rebate as may be allowed in accordance with the published prospectuses or tables of the insurer.\r\n"
						+ "\r\n"
						+ " \r\n"
						+ "\r\n"
						+ "Any person making default in complying with the provisions of this section shall be liable for a penalty which may extend to ten lakh rupees.");
				txtpnGhgfth.setEditable(false);
			
		}
		scrollPane.setViewportView(txtpnGhgfth);
		
		chckbxNewCheckBox = new JCheckBox("Accept Terms & Condition");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		chckbxNewCheckBox.setBounds(20, 537, 230, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFocusable(false);
		
		btnNewButton.setBounds(179, 575, 89, 23);
		contentPane.add(btnNewButton);

				
	}

}
