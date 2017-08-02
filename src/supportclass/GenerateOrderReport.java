/*
 * The class support these static function for generate the order bill report for Employeeworkspace
 * (temporary bill, receipt bill, kitchen bill,.....)
 */
package supportclass;

import entities.Customer;
import entities.Food;
import entities.Order;
import entities.OrderDetails;
import gui.employee.DiaEndofdayreport;
import gui.employee.FrShowReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CustomerDAO;
import model.FoodDAO;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import supportclass.printing.KitchenPrintTextForm;
import supportclass.printing.PrintTextForm;
import supportclass.printing.ReceiptPrintTextForm;
import supportclass.printing.TableItem;

/**
 *
 * @author DELL
 */
public class GenerateOrderReport {
    public static void generateTemporaryBill(PrintTextForm ptext, Entry<Order, ArrayList<OrderDetails>> cur_order, int cusnumber, int empnumber){
    	try{
			// tạo dataSource cho tập tin report
			List<Map<String, ?>> dataSource = new ArrayList<Map<String, ?>>();
			// truy xuất và xử lý dữ liệu, đưa vào dataSource
			createOtherData_TB(ptext, cur_order, cusnumber, empnumber, dataSource);
			createTableData_TB(ptext, cur_order, dataSource);
                        // tạo parameter cho report
                        String wifi = "cafe comma1/ cafe comma2";
                        String password = "123456789";
                        int price  = (int) (cur_order.getKey().getPrice() * 1000);
                        Map<String, Object> parameters = new HashMap<>();
                        parameters.put("price", price);
                        parameters.put("wifi", wifi);
                        parameters.put("password", password);
                        

			// khởi tạo jasperreport dataSource
			JRDataSource jrdata = new JRBeanCollectionDataSource(dataSource);
			// biên dịch tập tin jasperreport xml đã được thiết kế sẵn
			String filepath = "src/report/TemporaryBill.jrxml";
			JasperReport report = JasperCompileManager.compileReport(filepath);
			// nạp dataSource vào report
			JasperPrint filledReport = JasperFillManager.fillReport(report, parameters, jrdata);

			// xuất report trong frame
			new FrShowReport(new JRViewer(filledReport)).setVisible(true);
		}catch(JRException ex){
			Logger.getLogger(DiaEndofdayreport.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Somethings went wrong, can not generate the bill file", "REPORT WARNING", JOptionPane.ERROR_MESSAGE);
		}
    }
    
    public static void generateReceiptBill(ReceiptPrintTextForm ptext, Entry<Order, ArrayList<OrderDetails>> cur_order, int cusnumber, int empnumber){
        try{
            // tạo dataSource cho tập tin report
            List<Map<String, ?>> dataSource = new ArrayList<Map<String, ?>>();
            // truy xuất và xử lý dữ liệu, đưa vào dataSource
            createOtherData_RB(ptext, cur_order, cusnumber, empnumber, dataSource);
            createTableData_RB(ptext, cur_order, dataSource);
            // tạo parameter cho report
            String wifi = "cafe comma1/ cafe comma2";
            String password = "123456789";
            int customerpay = (int) (cur_order.getKey().getCustomerpay() * 1000);
            int price  = (int) (cur_order.getKey().getPrice() * 1000);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("customerpay", customerpay);
            parameters.put("price", price);
            parameters.put("wifi", wifi);
            parameters.put("password", password);

            // khởi tạo jasperreport dataSource
            JRDataSource jrdata = new JRBeanCollectionDataSource(dataSource);
            // biên dịch tập tin jasperreport xml đã được thiết kế sẵn
            String filepath = "src/report/ReceiptBill.jrxml";
            JasperReport report = JasperCompileManager.compileReport(filepath);
            // nạp dataSource vào report
            JasperPrint filledReport = JasperFillManager.fillReport(report, parameters, jrdata);

            // xuất report trong frame
            new FrShowReport(new JRViewer(filledReport)).setVisible(true);
        }catch(JRException ex){
            Logger.getLogger(DiaEndofdayreport.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Somethings went wrong, can not generate the bill file", "REPORT WARNING", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void generateKitchenBill(KitchenPrintTextForm ptext, Entry<Order, ArrayList<OrderDetails>> cur_order, Entry<Integer, ArrayList<String>> cur_ordernote, int cusnumber){
        try{
            // tạo dataSource cho tập tin report
            List<Map<String, ?>> dataSource = new ArrayList<Map<String, ?>>();
            // truy xuất và xử lý dữ liệu, đưa vào dataSource
            createOtherData_KB(ptext, cur_order, cur_ordernote, cusnumber, dataSource);
            createTableData_KB(ptext, cur_order, cur_ordernote, dataSource);


            // khởi tạo jasperreport dataSource
            JRDataSource jrdata = new JRBeanCollectionDataSource(dataSource);
            // biên dịch tập tin jasperreport xml đã được thiết kế sẵn
            String filepath = "src/report/KitchenBill.jrxml";
            JasperReport report = JasperCompileManager.compileReport(filepath);
            // nạp dataSource vào report
            JasperPrint filledReport = JasperFillManager.fillReport(report, null, jrdata);

            // xuất report trong frame
            new FrShowReport(new JRViewer(filledReport)).setVisible(true);
        }catch(JRException ex){
            Logger.getLogger(DiaEndofdayreport.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Somethings went wrong, can not generate the bill file", "REPORT WARNING", JOptionPane.ERROR_MESSAGE);
        }
    }




    private static void createOtherData_TB(PrintTextForm ptext, Entry<Order, ArrayList<OrderDetails>> cur_order, int cusnumber, int empnumber, List<Map<String, ?>> dataSource){
        // truy xuất và xử lý dữ liệu
        String address = "653 st.Le Van Luong, w.Tan Phong, d.7";
        String phone = "0862622858";
        int table = cur_order.getKey().getOrdertable();
        int customernumber = cusnumber;
        int employeenumber = empnumber;
        int discount = 0;
        ArrayList<Customer> cuslist = (ArrayList<Customer>) CustomerDAO.getList();
        for(Customer iter : cuslist){
            if(iter.getCus_id().equals(cur_order.getKey().getCus_id())){
                discount = iter.getDiscount();
                break;
            }
        }
        String orderid = cur_order.getKey().getOrder_id();
        
        
        // đưa dữ liệu và dataSource
        HashMap<String, Object> calculatefield = new HashMap<String, Object>();
        calculatefield.put("address", address);
        calculatefield.put("phone", phone);
        calculatefield.put("table", table);
        calculatefield.put("customernumber", customernumber);
        calculatefield.put("employeenumber", employeenumber);
        calculatefield.put("discount", discount);
        calculatefield.put("orderid", orderid);

        dataSource.add(calculatefield);
    }

    private static void createTableData_TB(PrintTextForm ptext, Entry<Order, ArrayList<OrderDetails>> cur_order, List<Map<String, ?>> dataSource){
        ArrayList<Food> foodlist = (ArrayList<Food>) FoodDAO.getList();

        for(OrderDetails oditem : cur_order.getValue()){
            for(Food fitem : foodlist){
                if(oditem.getFood_id().equals(fitem.getFood_id())){
                    HashMap<String, Object> newrecord = new HashMap();
                    newrecord.put("foodname", fitem.getName());
                    newrecord.put("quan", oditem.getQuan());
                    newrecord.put("price", (int) (fitem.getPrice() * 1000));
                    newrecord.put("amt", (int) (fitem.getPrice() * oditem.getQuan() * 1000));
                    
                    dataSource.add(newrecord);
                }
            }
        }
    }

    private static void createOtherData_RB(ReceiptPrintTextForm ptext, Entry<Order, ArrayList<OrderDetails>> cur_order, int cusnumber, int empnumber, List<Map<String, ?>> dataSource){
        String address = "653 st.Le Van Luong, w.Tan Phong, d.7";
        String phone = "0862622858";
        String wifi = "cafe comma1/ cafe comma2";
        String password = "123456789";
        int table = cur_order.getKey().getOrdertable();
        int customernumber = cusnumber;
        int employeenumber = empnumber;
        int discount = 0;
        ArrayList<Customer> cuslist = (ArrayList<Customer>) CustomerDAO.getList();
        for(Customer iter : cuslist){
            if(iter.getCus_id().equals(cur_order.getKey().getCus_id())){
                discount = iter.getDiscount();
                break;
            }
        }
        String orderid = cur_order.getKey().getOrder_id();
        //int customerpay = (int) (cur_order.getKey().getCustomerpay() * 1000);
        
        // đưa dữ liệu và dataSource
        HashMap<String, Object> calculatefield = new HashMap<String, Object>();
        calculatefield.put("address", address);
        calculatefield.put("phone", phone);
        calculatefield.put("wifi", wifi);
        calculatefield.put("password", password);
        calculatefield.put("table", table);
        calculatefield.put("customernumber", customernumber);
        calculatefield.put("employeenumber", employeenumber);
        calculatefield.put("discount", discount);
        calculatefield.put("orderid", orderid);
        //calculatefield.put("customerpay", customerpay);

        dataSource.add(calculatefield);
    }

    private static void createTableData_RB(ReceiptPrintTextForm ptext, Entry<Order, ArrayList<OrderDetails>> cur_order, List<Map<String, ?>> dataSource){
        ArrayList<Food> foodlist = (ArrayList<Food>) FoodDAO.getList();

        for(OrderDetails oditem : cur_order.getValue()){
            for(Food fitem : foodlist){
                if(oditem.getFood_id().equals(fitem.getFood_id())){
                    HashMap<String, Object> newrecord = new HashMap();
                    newrecord.put("foodname", fitem.getName());
                    newrecord.put("quan", oditem.getQuan());
                    newrecord.put("price", (int) (fitem.getPrice() * 1000));
                    newrecord.put("amt", (int) (fitem.getPrice() * oditem.getQuan() * 1000));
                    
                    dataSource.add(newrecord);
                }
            }
        }
    }

    private static void createOtherData_KB(KitchenPrintTextForm ptext, Entry<Order, ArrayList<OrderDetails>> cur_order, Entry<Integer, ArrayList<String>> cur_ordernote, int cusnumber, List<Map<String, ?>> dataSource){
        int table = cur_order.getKey().getOrdertable();
        String orderid = cur_order.getKey().getOrder_id();
        int customernumber = cusnumber;
        
        HashMap<String, Object> calculatefield = new HashMap<>();
        calculatefield.put("table", table);
        calculatefield.put("orderid", orderid);
        calculatefield.put("customernumber", customernumber);
        
        dataSource.add(calculatefield);
    }

    private static void createTableData_KB(KitchenPrintTextForm ptext, Entry<Order, ArrayList<OrderDetails>> cur_order, Entry<Integer, ArrayList<String>> cur_ordernote, List<Map<String, ?>> dataSource){
    	ArrayList<Food> foodlist = (ArrayList<Food>) FoodDAO.getList();

        for(int i = 0; i < cur_order.getValue().size(); i++){
            for(Food fitem : foodlist){
                if(cur_order.getValue().get(i).getFood_id().equals(fitem.getFood_id())){
                    HashMap<String, Object> newrecord = new HashMap();
                    newrecord.put("foodname", fitem.getName());
                    newrecord.put("quan", cur_order.getValue().get(i).getQuan());
                    // thêm note kèm sau món
                    String[] noteline = cur_ordernote.getValue().get(i).split("\n");
                    String note = "";
                    for(String line : noteline){
                        note +=  line + " ";
                    }
                    newrecord.put("note", note);
                    
                    dataSource.add(newrecord);
                }
            }
        }
    }
}
