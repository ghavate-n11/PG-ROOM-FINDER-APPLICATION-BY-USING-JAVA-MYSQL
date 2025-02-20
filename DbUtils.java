package pg.pgfinder;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSetMetaData;  // Correct import

public class DbUtils {

    public static TableModel resultSetToTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        
        // Number of columns in the ResultSet
        int columnCount = metaData.getColumnCount();
        
        // Create a DefaultTableModel with column headers
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add column names
        for (int i = 1; i <= columnCount; i++) {
            tableModel.addColumn(metaData.getColumnName(i));
        }

        // Add rows from the ResultSet
        Object[] rowData = new Object[columnCount];
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            tableModel.addRow(rowData);
        }

        return tableModel;  // Removed unreachable code
    }
}
