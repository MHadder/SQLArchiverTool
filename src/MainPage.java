import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.graphics.Point;


public class MainPage {

	private Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text text;


	/**
	 * @wbp.parser.entryPoint
	 */
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
		shell.setSize(555, 460);
		formToolkit.setBackground(null);
		shell.setText("SQL Archiver Tool");
		shell.setLayout(null);
	
		Composite composite_1 = new Composite(shell, SWT.BORDER);
		composite_1.setBounds(10, 10, 515, 30);
		composite_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Button btnEclipse = new Button(composite_1, SWT.RADIO);
		btnEclipse.setAlignment(SWT.CENTER);
		btnEclipse.setText("Eclipse");
		btnEclipse.setVisible(true);
		
		Label label = new Label(composite_1, SWT.NONE);
		formToolkit.adapt(label, true, true);
		label.setText("          ");
		
		Button btnEcapture = new Button(composite_1, SWT.RADIO);
		btnEcapture.setAlignment(SWT.CENTER);
		btnEcapture.setText("eCapture");
		
		Label label_1 = new Label(composite_1, SWT.NONE);
		label_1.setText("          ");
		formToolkit.adapt(label_1, true, true);
		
		Button btnBoth = new Button(composite_1, SWT.RADIO | SWT.RIGHT);
		btnBoth.setSelection(true);
		btnBoth.setAlignment(SWT.CENTER);
		btnBoth.setText("Both");
		
		Composite composite_2 = new Composite(shell, SWT.BORDER);
		composite_2.setBounds(10, 48, 515, 315);
		composite_2.setLayout(new GridLayout(6, false));
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblManagingClient = new Label(composite_2, SWT.NONE);
		lblManagingClient.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		lblManagingClient.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(lblManagingClient, true, true);
		lblManagingClient.setText("Managing Client:");
		new Label(composite_2, SWT.NONE);
		
		Combo combo = new Combo(composite_2, SWT.READ_ONLY);
		GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 183;
		combo.setLayoutData(gd_combo);
		formToolkit.adapt(combo);
		formToolkit.paintBordersFor(combo);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblClient = new Label(composite_2, SWT.NONE);
		lblClient.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(lblClient, true, true);
		lblClient.setText("Client");
		new Label(composite_2, SWT.NONE);
		
		Combo combo_1 = new Combo(composite_2, SWT.READ_ONLY);
		GridData gd_combo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_1.widthHint = 181;
		combo_1.setLayoutData(gd_combo_1);
		formToolkit.adapt(combo_1);
		formToolkit.paintBordersFor(combo_1);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblCase = new Label(composite_2, SWT.NONE);
		lblCase.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(lblCase, true, true);
		lblCase.setText("Case (Eclipse Only)");
		new Label(composite_2, SWT.NONE);
		
		Combo combo_2 = new Combo(composite_2, SWT.READ_ONLY);
		GridData gd_combo_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_2.widthHint = 182;
		combo_2.setLayoutData(gd_combo_2);
		formToolkit.adapt(combo_2);
		formToolkit.paintBordersFor(combo_2);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblDatabaseNames = new Label(composite_2, SWT.NONE);
		lblDatabaseNames.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(lblDatabaseNames, true, true);
		lblDatabaseNames.setText("Database Names");
		new Label(composite_2, SWT.NONE);
		
		Button button = new Button(composite_2, SWT.CHECK);
		button.setSelection(true);
		GridData gd_button = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_button.widthHint = 14;
		button.setLayoutData(gd_button);
		formToolkit.adapt(button, true, true);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblSystemDataLocations = new Label(composite_2, SWT.NONE);
		lblSystemDataLocations.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(lblSystemDataLocations, true, true);
		lblSystemDataLocations.setText("System Data Locations");
		new Label(composite_2, SWT.NONE);
		
		Button button_1 = new Button(composite_2, SWT.CHECK);
		button_1.setSelection(true);
		formToolkit.adapt(button_1, true, true);
		
		Button btnRunReport = new Button(composite_2, SWT.NONE);
		GridData gd_btnRunReport = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnRunReport.widthHint = 95;
		btnRunReport.setLayoutData(gd_btnRunReport);
		formToolkit.adapt(btnRunReport, true, true);
		btnRunReport.setText("Run Report");
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblSourceDataLocation = new Label(composite_2, SWT.NONE);
		lblSourceDataLocation.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		formToolkit.adapt(lblSourceDataLocation, true, true);
		lblSourceDataLocation.setText("Source Data Location");
		new Label(composite_2, SWT.NONE);
		
		Button button_2 = new Button(composite_2, SWT.CHECK);
		button_2.setSelection(true);
		formToolkit.adapt(button_2, true, true);
		new Label(composite_2, SWT.NONE);
		
		Composite composite_3 = new Composite(shell, SWT.BORDER);
		composite_3.setBounds(10, 372, 515, 35);
		composite_3.setLayout(new RowLayout(SWT.HORIZONTAL));
		formToolkit.adapt(composite_3);
		formToolkit.paintBordersFor(composite_3);
		
		Label lblReportOutputLocation = new Label(composite_3, SWT.NONE);
		lblReportOutputLocation.setLayoutData(new RowData(SWT.DEFAULT, 16));
		formToolkit.adapt(lblReportOutputLocation, true, true);
		lblReportOutputLocation.setText("Report Output Location");
		
		text = new Text(composite_3, SWT.BORDER);
		text.setLayoutData(new RowData(252, SWT.DEFAULT));
		formToolkit.adapt(text, true, true);
		
		Button btnBrowse = new Button(composite_3, SWT.NONE);
		btnBrowse.setLayoutData(new RowData(98, SWT.DEFAULT));
		formToolkit.adapt(btnBrowse, true, true);
		btnBrowse.setText("Browse");

	}
}
