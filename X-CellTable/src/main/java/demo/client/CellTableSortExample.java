package demo.client;

// GWT Client
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

// GWT CellView
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.ColumnSortList;

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

    CellTable<Contact> table;
    TextColumn<Contact> nameColumn;
    DateCell dateCell;
    TextColumn<Contact> addressColumn;
    ListDataProvider<Contact> dataProvider;

    /**
     * A simple data type that represents a contact.
     */
    private static class Contact {
        public final String address;
        private final Date birthday;
        public final String name;
        public Contact(String name, Date birthday, String address) {
            this.name = name;
            this.birthday = birthday;
            this.address = address;
        }
    }

  /**
   * The list of data to display.
   */
  private static final List<Contact> CONTACTS = Arrays.asList(
      new Contact("John", new Date(80, 4, 12), "123 Fourth Avenue"),
      new Contact("Joe", new Date(85, 2, 22), "22 Lance Ln"),
      new Contact("George", new Date(46, 6, 6), "1600 Pennsylvania Avenue")
    );
  

  //=======================================================================================

  public void onModuleLoad() {

    // Create a CellTable.
    table = new CellTable<Contact>();
    table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

    createColumns();

    // Create a list data provider.
    dataProvider = new ListDataProvider<Contact>();

    // Add the CellTable to the dataProvider.
    dataProvider.addDataDisplay(table);


    // Add the value to the list. The dataProvider will update the cellList.
    List<Contact> list = dataProvider.getList();
    for(Contact contact: CONTACTS)
        list.add(contact);

    createSortHandler();

    //
    ColumnSortList columnSortList = table.getColumnSortList();
    columnSortList.clear();
    columnSortList.push(nameColumn);

    dataProvider.refresh();

    // Add the widgets to the root panel.
    VerticalPanel vPanel = new VerticalPanel();
    // vPanel.add(addButton);
    vPanel.add(table);
    RootPanel.get().add(vPanel);
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

        // Assemble the table
        table.addColumn(nameColumn, "Name");
        table.addColumn(dateColumn, "Birthday");
        table.addColumn(addressColumn, "Address");
    }

    private void createSortHandler() {

        // Create a sort handler
        ListHandler<Contact> columnSortHandler = new ListHandler<>(dataProvider.getList());

        columnSortHandler.setComparator(nameColumn,
            new Comparator<Contact>() {
                public int compare(Contact o1, Contact o2) {
                    return o1.name.compareTo(o2.name);    // Ascending
                    // return o2.name.compareTo(o1.name); // Descending
                }
            }
        );

        table.addColumnSortHandler(columnSortHandler);

    }
}
