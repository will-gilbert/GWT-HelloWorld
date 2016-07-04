package demo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.view.client.Range;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.ArrayList;
import java.util.List;


// Pushing data asynchronously with Async Data Provider
public class AsyncDataProviderExample implements EntryPoint {

  /**
   * A custom {@link AsyncDataProvider}.
   */
  private static class MyDataProvider extends AsyncDataProvider<String> {

    /**
     * {@link #onRangeChanged(HasData)} is called when the table requests a new
     * range of data. You can push data back to the displays using
     * {@link #updateRowData(int, List)}.
     */

    @Override
    protected void onRangeChanged(HasData<String> display) {
      // Get the new range.
      final Range range = display.getVisibleRange();

      /*
       * Query the data asynchronously. If you are using a database, you can
       * make an RPC call here. We'll use a Timer to simulate a delay.
       */

      new Timer() {
        
        @Override
        public void run() {
          // We are creating fake data. Normally, the data will come from a
          // server.
          int start = range.getStart();
          int length = range.getLength();
          List<String> newData = new ArrayList<String>();
          for (int i = start; i < start + length; i++) {
            newData.add("Item " + i);
          }

          // Push the data to the displays. AsyncDataProvider will only update
          // displays that are within range of the data.
          updateRowData(start, newData);
        }
      }.schedule(3000);
    }
  }

  public void onModuleLoad() {

    // Create a CellList.
    CellList<String> cellList = new CellList<String>(new TextCell());

    // Create a data provider.
    MyDataProvider dataProvider = new MyDataProvider();

    // Add the cellList to the dataProvider.
    dataProvider.addDataDisplay(cellList);

    // Create paging controls.
    SimplePager pager = new SimplePager();
    pager.setDisplay(cellList);

    // Add the widgets to the root panel.
    VerticalPanel vPanel = new VerticalPanel();
    vPanel.add(pager);
    vPanel.add(cellList);
    RootPanel.get().add(vPanel);
  }
}

