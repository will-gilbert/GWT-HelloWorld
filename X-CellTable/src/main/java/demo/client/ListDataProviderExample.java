package demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;

import java.util.List;

/**
* Pushing data with List Data Provider (backed by List)
*/

public class ListDataProviderExample implements EntryPoint {

  public void onModuleLoad() {

    // Create a CellList.
    CellList<String> cellList = new CellList<String>(new TextCell());

    // Create a list data provider.
    final ListDataProvider<String> dataProvider = new ListDataProvider<String>();

    // Add the cellList to the dataProvider.
    dataProvider.addDataDisplay(cellList);

    // Create a form to add values to the data provider.
    final TextBox valueBox = new TextBox();
    valueBox.setText("Enter new value");

    Button addButton = new Button("Add value", new ClickHandler() {
        
      public void onClick(ClickEvent event) {
        // Get the value from the text box.
        String newValue = valueBox.getText();

        // Get the underlying list from data dataProvider.
        List<String> list = dataProvider.getList();

        // Add the value to the list. The dataProvider will update the cellList.
        list.add(newValue);
      }
    });

    // Add the widgets to the root panel.
    VerticalPanel vPanel = new VerticalPanel();
    vPanel.add(valueBox);
    vPanel.add(addButton);
    vPanel.add(cellList);
    RootPanel.get().add(vPanel);
  }
}
