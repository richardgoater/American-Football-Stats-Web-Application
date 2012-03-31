package uk.co.richardgoater.stats;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import uk.co.richardgoater.stats.persistence.dao.ScheduleDAO;
import uk.co.richardgoater.stats.persistence.dao.gamedata.GameDataDAO;
import uk.co.richardgoater.stats.ui.AdminLoginWindow;
import uk.co.richardgoater.stats.ui.SeasonSelector;
import uk.co.richardgoater.stats.ui.WeekSelector;
import uk.co.richardgoater.stats.ui.table.DefenseTable;
import uk.co.richardgoater.stats.ui.table.PassingTable;
import uk.co.richardgoater.stats.ui.table.ReceivingTable;
import uk.co.richardgoater.stats.ui.table.RushingTable;
import uk.co.richardgoater.stats.ui.table.StatsTable;

import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.terminal.gwt.server.WebApplicationContext;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class StatsApplication extends Application {

	private static final long serialVersionUID = -6022858661706963747L;
	private ApplicationContext context;
	private ScheduleDAO dao;

	// UI Components
	private Window mainWindow;
	private HorizontalLayout adminControlLayout = new HorizontalLayout();

	private PassingTable passingTable;
	private RushingTable rushingTable;
	private ReceivingTable receivingTable;
	private DefenseTable defenseTable;

	String theme = "watfordcheetahs";
	private Button adminloginButton;

	@Override
	public void init() {

		context = getSpringContext();

		dao = (ScheduleDAO) context.getBean("ScheduleDAO");

		setTheme(theme);

		mainWindow = new Window("Watford Cheetahs Stats");

		// Label headerLabel = new Label("Stats");
		// headerLabel.setStyleName("wcheader");
		// mainWindow.addComponent(headerLabel);

		passingTable = new PassingTable((GameDataDAO) context.getBean("PassingGameDataDAO"));
		rushingTable = new RushingTable((GameDataDAO) context.getBean("RushingGameDataDAO"));
		receivingTable = new ReceivingTable((GameDataDAO) context.getBean("ReceivingGameDataDAO"));
		defenseTable = new DefenseTable((GameDataDAO) context.getBean("DefenseGameDataDAO"));
		
		ArrayList<StatsTable> tableList = new ArrayList<StatsTable>();
		tableList.add(passingTable);
		tableList.add(rushingTable);
		tableList.add(receivingTable);
		tableList.add(defenseTable);
		
		HorizontalLayout selectorLayout = new HorizontalLayout();
		WeekSelector ws = new WeekSelector(tableList, dao);
		selectorLayout.addComponent(new SeasonSelector(tableList, dao, ws));
		addSpacer(selectorLayout);
		selectorLayout.addComponent(ws);
		mainWindow.addComponent(selectorLayout);

		createTabsheet();

		// createAdminControls();

		setMainWindow(mainWindow);
	}

	private ApplicationContext getSpringContext() {
		ServletContext servletContext = ((WebApplicationContext) this
				.getContext()).getHttpSession().getServletContext();
		return WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
	}

	@SuppressWarnings("unused")
	private void createAdminControls() {
		Label space = new Label("");
		space.setHeight("12pt");
		mainWindow.addComponent(space);

		adminloginButton = new Button("ADMIN LOGIN");
		adminloginButton.addListener(new LoginListener());
		adminControlLayout.addComponent(adminloginButton);
		mainWindow.addComponent(adminControlLayout);
	}

	private void createTabsheet() {

		TabSheet tabsheet = new TabSheet();
		tabsheet.addTab(passingTable, "Passing", null);
		tabsheet.addTab(rushingTable, "Rushing", null);
		tabsheet.addTab(receivingTable, "Receiving", null);
		tabsheet.addTab(defenseTable, "Defense", null);

		tabsheet.setSizeUndefined();
		tabsheet.setWidth("100%");

		mainWindow.addComponent(tabsheet);
	}

	@SuppressWarnings("serial")
	private final class LoginListener implements Button.ClickListener {

		public void buttonClick(ClickEvent event) {
			final AdminLoginWindow w = new AdminLoginWindow("Admin Login");
			Button b = w.getButton();
			b.addListener(new Button.ClickListener() {

				public void buttonClick(ClickEvent event) {
					addExtraControlsOnLogin();
					mainWindow.removeWindow(w);
					adminloginButton.setEnabled(false);
				}

				private void addExtraControlsOnLogin() {
					// leading space
					addSpacer(adminControlLayout);

					// Edit CheckBox
					final CheckBox switchEditable = new CheckBox("Edit?");
					switchEditable
							.addListener(new Property.ValueChangeListener() {
								public void valueChange(ValueChangeEvent event) {
									boolean val = ((Boolean) event
											.getProperty().getValue())
											.booleanValue();
									passingTable.setEditable(val);
									rushingTable.setEditable(val);
									receivingTable.setEditable(val);
									defenseTable.setEditable(val);
								}
							});
					switchEditable.setImmediate(true);
					adminControlLayout.addComponent(switchEditable);
					addSpacer(adminControlLayout);

					// AddPlayer Button
					adminControlLayout.addComponent(new Button("Add Player"));
					addSpacer(adminControlLayout);

					// RemovePlayer Button
					adminControlLayout
							.addComponent(new Button("Remove Player"));
					addSpacer(adminControlLayout);

					// AddScheduleWeek Button
					adminControlLayout.addComponent(new Button(
							"Add Schedule Week"));
					addSpacer(adminControlLayout);

					// RemoveSceduleWeek Button
					adminControlLayout.addComponent(new Button(
							"Remove Schedule Week"));
					addSpacer(adminControlLayout);

					// Submit Button
					adminControlLayout.addComponent(new Button("Commit"));
				}
			});
			mainWindow.addWindow(w);
		}
	}
	
	private void addSpacer(Layout l) {
		Label s = new Label();
		s.setWidth("10px");
		l.addComponent(s);
	}
}
