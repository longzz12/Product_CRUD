package Product;

import java.awt.event.*;
import java.awt.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class FormProduct implements ActionListener{
    JFrame frame = new JFrame();
    JTextField txtTitle = new JTextField();
    JLabel lbId = new   JLabel("ID");
    JLabel lbName = new JLabel("Name");
    JLabel lbQty = new  JLabel("Quantity");
    JLabel lbPrice =new JLabel("Price");
    JTextField txtId = new JTextField();
    JTextField txtName = new JTextField();
    JTextField txtQty = new JTextField();
    JTextField txtPrice = new JTextField();
    JButton btnWrite = new JButton("Write");
    JButton btnRead = new JButton("Read");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");
    JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    
    private ArrayList<ProductModel> listAdd =new ArrayList<ProductModel>();
    
    String[][] data = {};
    String[] header = { "ID", "Name", "Quantity","Price"};
    
    
    FormProduct() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,650);
	//frame.getContentPane().setBackground(new Color(50,50,50));
	frame.setLayout(null);
        frame.setLocationRelativeTo(null);
	frame.setResizable(false);
        
        txtTitle.setBounds(0,0,900,50);
	//txtTitle.setBackground(new Color(25,25,25));
	//txtTitle.setForeground(new Color(25,255,0));
	txtTitle.setFont(new Font("Arail",Font.BOLD,30));
	txtTitle.setBorder(BorderFactory.createBevelBorder(1));
	txtTitle.setHorizontalAlignment(JTextField.CENTER);
	txtTitle.setEditable(false);
        txtTitle.setText("Product Management");
        
        table = new JTable(data, header){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        table.setBounds(50, 100, 800, 300);
        table.getTableHeader().setBounds(50, 70, 800, 30);
        table.setModel(new DefaultTableModel(
                data, header
        ));
        table.setRowSelectionAllowed(true);
        scrollPane= new JScrollPane(table);
        
        
        lbId.setBounds(50, 425, 100, 25);
        lbId.setFont(new Font("Arail",Font.PLAIN,14));
	//lbId.setForeground(new Color(25,255,0));
        txtId.setBounds(125, 425, 150, 25);
        txtId.setFont(new Font("Arail",Font.PLAIN,14));
	//txtId.setForeground(new Color(25,255,0));
        
        lbName.setBounds(350, 425, 100, 25);
        lbName.setFont(new Font("Arail",Font.PLAIN,14));
	//lbName.setForeground(new Color(25,255,0));
        txtName.setBounds(475, 425, 150, 25);
        txtName.setFont(new Font("Arail",Font.PLAIN,14));
	//txtName.setForeground(new Color(25,255,0));
        
        lbQty.setBounds(50, 475, 100, 25);
        lbQty.setFont(new Font("Arail",Font.PLAIN,14));
	//lbQty.setForeground(new Color(25,255,0));
        txtQty.setBounds(125, 475, 150, 25);
        txtQty.setFont(new Font("Arail",Font.PLAIN,14));
	//txtQty.setForeground(new Color(25,255,0));
        
        lbPrice.setBounds(350, 475, 100, 25);
        lbPrice.setFont(new Font("Arail",Font.PLAIN,14));
	//lbPrice.setForeground(new Color(25,255,0));
        txtPrice.setBounds(475, 475, 150, 25);
        txtPrice.setFont(new Font("Arail",Font.PLAIN,14));
	//txtPrice.setForeground(new Color(25,255,0));
        
        btnWrite.setBounds(50, 550, 100, 40);
        btnWrite.setBackground(Color.GREEN.darker());
        btnWrite.setForeground(Color.white);
        
        
        btnRead.setBounds(200, 550, 100, 40);
        btnRead.setBackground(Color.CYAN.darker());
        btnRead.setForeground(Color.white);
//        
        btnUpdate.setBounds(350, 550, 100, 40);
        btnUpdate.setBackground(Color.blue);
        btnUpdate.setForeground(Color.white);
//        
//        btnClear.setBounds(500, 550, 100, 40);
//        btnClear.setBackground(Color.GRAY);
//        btnClear.setForeground(Color.white);
        
        btnWrite.addActionListener(this);
        btnRead.addActionListener(this);
        btnUpdate.addActionListener(this);
//        btnDelete.addActionListener(this);
//        btnClear.addActionListener(this);
        
        frame.add(btnWrite);
        frame.add(btnRead);
        frame.add(btnUpdate);
        frame.add(btnDelete);
        frame.add(btnClear);
        frame.add(lbQty);
        frame.add(txtQty);
        frame.add(lbPrice);
        frame.add(txtPrice);
        frame.add(lbName);
        frame.add(txtName);
        frame.add(txtId);
        frame.add(lbId);
        frame.add(table.getTableHeader());
        frame.add(scrollPane);        
        frame.add(table);
        frame.add(txtTitle);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnWrite) {
            /*var id = txtId.getText();
            var name = txtName.getText();
            var qty = txtQty.getText();
            var price = txtPrice.getText();
            if(!id.isEmpty() && !name.isEmpty() && !qty.isEmpty() && !price.isEmpty()){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{
                    txtId.getText(),
                    txtName.getText(),
                    txtQty.getText(),
                    txtPrice.getText(),
                });
                JOptionPane.showMessageDialog(null, "Product Added...");
                
            }else {
                JOptionPane.showMessageDialog(null, "Please enter all field!");
            }
            clearAllField();
            */
            myWrite();
        }
        if(ae.getSource() == btnRead) {
            myRead();
        }
        if(ae.getSource() == btnUpdate) {
            try {
                update();
                /*DefaultTableModel model = (DefaultTableModel) table.getModel();
                
                var id = txtId.getText();
                var name = txtName.getText();
                var qty = txtQty.getText();
                var price = txtPrice.getText();
                if(!id.isEmpty() && !name.isEmpty() && !qty.isEmpty() && !price.isEmpty()){
                if(table.getSelectedRowCount() == 1) {
                model.setValueAt(id, table.getSelectedRow(), 0);
                model.setValueAt(name, table.getSelectedRow(), 1);
                model.setValueAt(qty, table.getSelectedRow(), 2);
                model.setValueAt(price, table.getSelectedRow(), 3);
                
            
                JOptionPane.showMessageDialog(null, "Product updated...");
                }
                else if(table.getSelectedRowCount() == 0) {
                JOptionPane.showConfirmDialog(null, "Please select a Product!");
                }
                }
                else {
                JOptionPane.showConfirmDialog(null, "Please enter all field!");
                }
                clearAllField();
                */
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormProduct.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        if(ae.getSource() == btnDelete) {
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            if(table.getSelectedRowCount() == 1 ){
                 
            }
            /*var makeSure = JOptionPane.showConfirmDialog(null, "Do you want to delete this product?", "Confirmation", ConfirmationCallback.YES_NO_OPTION);
            if(makeSure == JOptionPane.YES_OPTION) {
                if(table.getSelectedRowCount() == 1) {
                    model.removeRow(table.getSelectedRow());
                    JOptionPane.showConfirmDialog(null, "Remove product from table successful...");
                }else{
                    if(table.getSelectedRowCount() == 0) {
                        JOptionPane.showConfirmDialog(null, "The table is empty!");
                    }else{
                        JOptionPane.showConfirmDialog(null, "Please select a Product!");
                    }
                }
            }
            else if(makeSure == JOptionPane.NO_OPTION){
                return;
            }
            */
            
        }
        if(ae.getSource() == btnClear) {
            var makeSure = JOptionPane.showConfirmDialog(null, "Do you want to clear this table?", "Confirmation", ConfirmationCallback.YES_NO_OPTION);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            if(makeSure == JOptionPane.YES_OPTION) {
                model.setRowCount(0);
            }
            else if(makeSure == JOptionPane.NO_OPTION){
                return;
            }
        }
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
                    int i = table.getSelectedRow();
                    TableModel model = table.getModel();
                    txtId.setText(model.getValueAt(i,0).toString());
                    txtName.setText(model.getValueAt(i,1).toString());
                    txtQty.setText(model.getValueAt(i,2).toString());
                    txtPrice.setText(model.getValueAt(i,3).toString());
                }
            }
        });
    }
    public void clearAllField() {
        txtId.setText("");
        txtName.setText("");
        txtQty.setText("");
        txtPrice.setText("");
    }
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(int i=model.getRowCount()-1;i>=0;i--){
            model.removeRow(i);
        }
   }
    
//    public void myAdd(){
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        Object []row={txtId.getText(),txtName.getText(),txtQty.getText(),txtPrice.getText()};
//        model.addRow(row);
//   }
    public void update() throws ClassNotFoundException {
        listAdd.add(getProductModel());
        try{
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            if(table.getSelectedRowCount() == 1){
                FileInputStream inFile = new FileInputStream("C:\\Users\\rinpi\\OneDrive\\Desktop\\RUPP\\JavaProject1\\ProductStore.txt");
                ObjectInputStream objIn = new ObjectInputStream(inFile);
//                ProductModel obj = (ProductModel)objIn.readObject();
                listAdd =(ArrayList<ProductModel>)objIn.readObject();
                inFile.close();
                objIn.close();
                listAdd =(ArrayList<ProductModel>)objIn.readObject();
                //listAdd.removeIf((value) -> value.equals(model.getValueAt(1, 1)));
            }
            
            
            
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void  myWrite(){
      listAdd.add(getProductModel());
      try{
         ObjectOutputStream out=new ObjectOutputStream(new
                 FileOutputStream("C:\\Users\\rinpi\\OneDrive\\Desktop\\RUPP\\JavaProject1\\ProductStore.txt"));
         out.writeObject(listAdd);
         JOptionPane.showMessageDialog(null, "Write succesfully");
         
         out.close();
      }catch(IOException e){e.printStackTrace();}
   }
    public void myRead(){
      listAdd.clear();
      clearTable();
      read();
      addToTable(listAdd);
    }
    public ProductModel getProductModel() {
        int id = Integer.parseInt(txtId.getText());
        int qty = Integer.parseInt(txtQty.getText());
        String name = txtName.getText();
        double price = Double.parseDouble(txtPrice.getText());
        clearAllField();
        
        return new ProductModel(id, name, qty, price);
    }
    public void read(){
      try{
         ObjectInputStream in=new ObjectInputStream(new
                 FileInputStream("C:\\Users\\rinpi\\OneDrive\\Desktop\\RUPP\\JavaProject1\\ProductStore.txt"));
         try{
            while(true){
                  listAdd =(ArrayList<ProductModel>)in.readObject();
            }		
         }
      catch(EOFException e){in.close(); }
      catch(ClassNotFoundException e){e.printStackTrace();}
      //JOptionPane.showMessageDialog(null, "Read  suceesfully");
      }catch(IOException e){e.printStackTrace();}
    }
    public void addToTable(ArrayList<ProductModel>listAdd){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(int i=0;i<listAdd.size();i++){
            Object[] row = {
                listAdd.get(i).getId(),
                listAdd.get(i).getName(),
                listAdd.get(i).getQty(),
                listAdd.get(i).getPrice()
            };
            model.addRow(row);
        }
    }
}
    