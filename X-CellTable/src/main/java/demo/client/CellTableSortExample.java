package demo.client;

// GWT Data Support
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.view.client.ListDataProvider;

// GWT DOM Events
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.dom.client.Style.Unit;

// GWT Widgets
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

// GWT CellView
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.ColumnSortList;
import com.google.gwt.user.cellview.client.ColumnSortList.ColumnSortInfo;
import com.google.gwt.user.cellview.client.ColumnSortEvent;

// Java Collections
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Comparator;

/**
* Sorting a table then changing the List Data Provider (backed by List) content
* Does the remain sorted?
*/

public class CellTableSortExample implements EntryPoint {

    final VerticalPanel content = new VerticalPanel();

    CellTable<Contact> table;
    TextColumn<Contact> nameColumn;
    DateCell dateCell;
    TextColumn<Contact> addressColumn;
    ListDataProvider<Contact> dataProvider;

    // Number of time the 'Load a new List' has been clicked
    int clicks = 0;

    /**
     * A simple data type that represents a contact.
     */
    private static class Contact {
        public final String name;
        private final Date birthday;
        public final String address;
        public Contact(String name, Date birthday, String address) {
            this.name = name;
            this.birthday = birthday;
            this.address = address;
        }
    }

  /**
   * Two lists of data to display. Uses 'click' to swap lists into the table.
   */
  private static final List<Contact> CONTACTS = Arrays.asList(
      new Contact("John", new Date(80, 4, 12), "Fourth Avenue"),
      new Contact("Joe", new Date(85, 2, 22), "Lance Ln"),
      new Contact("George", new Date(46, 6, 6), "Pennsylvania Avenue")
    );

  private static final List<Contact> CONTACTS2 = Arrays.asList(
      new Contact("Peter", new Date(80, 4, 12), "Fourth Avenue"),
      new Contact("Paul", new Date(85, 2, 22), "Lance Ln"),
      new Contact("Mary", new Date(46, 6, 6), "Pennsylvania Avenue")
    );
  

  //=======================================================================================

  public void onModuleLoad() {

    // Create a CellTable.
    table = new CellTable<Contact>();
    table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

    // Define the columns with value renderers and labels
    createColumns();

    // Create the data provider
    dataProvider = new ListDataProvider<Contact>();
   
    // Create the sort handler and connecting it to the data provider
    table.addColumnSortHandler(createColumnSortHandler(dataProvider));

    // Connect the CellTable to the data provider
    dataProvider.addDataDisplay(table);

    // Add the first list
    dataProvider.getList().addAll(CONTACTS);

    // Programatically sort by name, ascending
    sortByName(true);

    // Add the widgets to the root panel; User will click on the 'Load a new list' button
    content.add(table);
    content.add(createListToggleButton(table, dataProvider));

    RootPanel.get().add(content);
  }


    private void createColumns() {

        // Add a text column to show the name.
        nameColumn = new TextColumn<Contact>() {
            @Override
            public String getValue(Contact object) {
                return object.name;
            }
        };

        // Add a date column to show the birthday.
        dateCell = new DateCell();
        Column<Contact, Date> dateColumn = new Column<Contact, Date>(dateCell) {
            @Override
            public Date getValue(Contact object) {
                return object.birthday;
            }
        };

        // Add a text column to show the address.
        addressColumn = new TextColumn<Contact>() {
            @Override
            public String getValue(Contact object) {
                return object.address;
            }
        };

        // Column widths in font width
        table.setColumnWidth(nameColumn, 15.0, Unit.EX);
        table.setColumnWidth(dateColumn, 35.0, Unit.EX);
        table.setColumnWidth(addressColumn, 35.0, Unit.EX);

        // Assemble the table
        table.addColumn(nameColumn, "Name");
        table.addColumn(dateColumn, "Birthday");
        table.addColumn(addressColumn, "Address");
    }

    private ListHandler<Contact> createColumnSortHandler(ListDataProvider<Contact> dataProvider) {

        // Create a sort handler
        ListHandler<Contact> columnSortHandler = new ListHandler<>(dataProvider.getList());

        // Create a sorter for the name
        nameColumn.setSortable(true);
        columnSortHandler.setComparator(nameColumn,
            new Comparator<Contact>() {
                public int compare(Contact o1, Contact o2) {
                    return o1.name.compareTo(o2.name);
                }
            }
        );

        // Create a sorter for the address
        addressColumn.setSortable(true);
        columnSortHandler.setComparator(addressColumn,
            new Comparator<Contact>() {
                public int compare(Contact o1, Contact o2) {
                    return o1.address.compareTo(o2.address);
                }
            }
        );

        return columnSortHandler;
    }


    private void sortByName(boolean ascending) {

        ColumnSortInfo columnSortInfo = new ColumnSortInfo(nameColumn, ascending);
        table.getColumnSortList().push( columnSortInfo );
        ColumnSortEvent.fire(table, table.getColumnSortList());

    }


    private Button createListToggleButton(final CellTable table, final ListDataProvider dataProvider) {
        // New list should sort the same
        Button newListButton = new Button("Load a new List", new ClickHandler() {
        
            public void onClick(ClickEvent event) {
                clicks++;
                dataProvider.getList().clear();
                dataProvider.getList().addAll((clicks % 2 == 0) ? CONTACTS: CONTACTS2);
                ColumnSortEvent.fire(table, table.getColumnSortList());
            }

        });

        return newListButton;        
    }

}
