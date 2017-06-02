import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;

import javax.swing.JOptionPane;

public class SQLLandingPage {

	private Shell shell;
	private Text serverNameText;
	private Text ADDConfigText;
	private Text usernameText;
	private Text passwordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SQLLandingPage window = new SQLLandingPage();
			window.open();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void open() {
		Display display = Display.getDefault();
		initialize();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		shell = new Shell();
		shell.setMinimumSize(new Point(500, 300));
		shell.setSize(500, 300);
		shell.setText("SQL Archiver Tool");
		shell.setLayout(new GridLayout(4, false));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblSqlServerName = new Label(shell, SWT.NONE);
		lblSqlServerName.setText("SQL Server Name");
		new Label(shell, SWT.NONE);
		
		serverNameText = new Text(shell, SWT.BORDER);
		serverNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblIproAddConfig = new Label(shell, SWT.NONE);
		lblIproAddConfig.setText("Ipro ADD config database");
		new Label(shell, SWT.NONE);
		
		ADDConfigText = new Text(shell, SWT.BORDER);
		ADDConfigText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblSqlLogin = new Label(shell, SWT.NONE);
		lblSqlLogin.setText("SQL Login");
		new Label(shell, SWT.NONE);
		
		usernameText = new Text(shell, SWT.BORDER);
		usernameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Label lblSqlPassword = new Label(shell, SWT.NONE);
		lblSqlPassword.setText("SQL Password");
		new Label(shell, SWT.NONE);
		
		passwordText = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		GridData gd_passwordText = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_passwordText.widthHint = 268;
		passwordText.setLayoutData(gd_passwordText);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
		Button btnValidate = new Button(shell, SWT.NONE);

		GridData gd_btnValidate = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnValidate.widthHint = 87;
		btnValidate.setLayoutData(gd_btnValidate);
		btnValidate.setText("Validate");
		new Label(shell, SWT.NONE);
		
		//Next Button Handler
		Button btnNext = new Button(shell, SWT.NONE);
		btnNext.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				nextPage();
			}
		});
		btnNext.setEnabled(false);
		GridData gd_btnNext = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnNext.widthHint = 105;
		btnNext.setLayoutData(gd_btnNext);
		btnNext.setText("Next");		
		
		//Validate button listener
		btnValidate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String username = usernameText.getText();
				String password = passwordText.getText();
				String config = ADDConfigText.getText();
				String machine;
				String instance;
				String temp = serverNameText.getText();
				int index = temp.indexOf('\\');
				if (index >= 0)
				{
					machine = temp.substring(0, index);
					instance = temp.substring(index+1);
				}
				else
				{
					machine = temp;
					instance = null;
				}
				if(validateSQL(username, password, instance, config, machine))
				{
					btnNext.setEnabled(true);
				
				}
				else
				{
					//TODO: Make a pop-up window that says validation failed and to try again
				}
				
			}
		});

	}
	
	public static void nextPage() {
		try {
			MainPage nextWindow = new MainPage();
			nextWindow.open();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean validateSQL(String username, String password, String instance, String ADD_Config, String machine)
	{
		try
		{
			String url = "";
			if(instance.equals(""))
			{
				url = "jdbc:sqlserver://" + machine + ":1433;databasename=" + ADD_Config;
			}
			else
			{
				url = "jdbc:sqlserver://" + machine + ";databasename=" + ADD_Config + ";instanceName=" + instance + ";user=" + username + ";password=" + password;
			}
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Enterprise.CaseProductEnvironment");
			conn.close();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
