package biodata;
import java.sql.*;
import java.text.SimpleDateFormat;
import koneksi.DB_form;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Inputan extends javax.swing.JFrame {
    DB_form con;
    private Object [][] TblBiodata = null;
    private String [] label = {"Nama","Nomor","Jenis Kelamin","Kelas","Tanggal Lahir","Alamat"};

    
    
    public Inputan() throws SQLException {
        initComponents();
        con = new DB_form();
        con.Class();
        BacaTabel();
        nomor1.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    
    
    
    
    private  void Tabel() {
        
        try{
            con.ss = (Statement) con.cc.createStatement();
            String sql = "insert* from inputan Ordey By Tnomor";
            con.rs = con.ss.executeQuery(sql);
            ResultSetMetaData m = con.rs.getMetaData();//Menentukan ulang jumlah kolom di model.
            int kolom = m.getColumnCount();
            int baris = 0;
            while (con.rs.next()){
                baris= con.rs.getRow();
             
                //Fungsi resulset disini akan digunakan saat kita menggunakan statement select ke database, 
                //lebih jelasnya resultset adalah pengontrol letak kursor terhadap suatu baris didalam database, 
                //sehingga apa yg kita pilih
            }
            
        }catch (Exception e){
        }
        
}
    
    public final void tgl(){
        Date skrg = new Date ();
                SimpleDateFormat format= new SimpleDateFormat ("dd MMMM yyyy");
                String tanggal = format.format(skrg);
    }
    private void simpan(){
        String nomor = this.nomor1.getText();
        String nama = this.nama1.getText();
        String jekel = (String) this.jk.getSelectedItem();
        String kelas = (String) this.kelas1.getSelectedItem();
        java.util.Date tanggal = (java.util.Date) this.tgl.getDate();
        String alamat = this.alamat1.getText();
        
        try{
            String sql = "Insert into inputan values (?,?,?,?,?,?)";
            PreparedStatement p = (PreparedStatement) con.cc.prepareStatement(sql);
            p.setString(1,nomor);
            p.setString(2,nama);
            p.setString(3,jekel);
            p.setString(4,kelas);
            p.setDate(5,new java.sql.Date(tanggal.getTime()));
            p.setString(6,alamat);
            p.executeUpdate();
            
            BacaTabel();
            
             JOptionPane.showMessageDialog(this,"Data berhasil di input");
            
        }catch (Exception e){
            System.out.println(e);    
        }  
    }
    private void edit(){
        String nomor = this.nomor1.getText();
        String nama = this.nama1.getText();
        String jekel = (String) this.jk.getSelectedItem();
        String kelas = (String) this.kelas1.getSelectedItem();
        java.util.Date tanggal = (java.util.Date) this.tgl.getDate();
        String alamat = this.alamat1.getText();
        
        try{
            String sql = "Update inputan Set Tnama=? , Tjeniskelamin=?,Tkelas=?,"
                    + "Ttanggallahir=?,Talamat=? where Tnomor=?";
            PreparedStatement p = (PreparedStatement) con.cc.prepareStatement(sql);
            p.setString(6,nomor);
            p.setString(1,nama);
            p.setString(2,jekel);
            p.setString(3,kelas);
            p.setDate(4,new java.sql.Date(tanggal.getTime()));
            p.setString(5,alamat);
            p.executeUpdate();
            
            BacaTabel();
            
             JOptionPane.showMessageDialog(this,"Anda Berhasil Mengedit");
            
        }catch (Exception e){
            System.out.println(e);    
        }  
    }
    
    private void hapus() {
        try{
           String sql ="Delete from inputan Where Tnomor='"+nomor1.getText()+"'"; 
           con.ss.executeUpdate(sql);
           con.ss.close();
           JOptionPane.showMessageDialog(null,"Data berhasil di Hapus");
           BacaTabel();
           nomor1.requestFocus();
           
        }catch (Exception e){   
             JOptionPane.showMessageDialog(null,e);
        } 
    }
    
    private void baru(){
      
            nama1.setText("");
            nomor1.setText("");
            jk.setSelectedItem(null);
            kelas1.setSelectedItem(null);
            tgl.setDate(null);
            alamat1.setText("");
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ftabel = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nama1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nomor1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jk = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        kelas1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tgl = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        ftabel.setAutoCreateRowSorter(true);
        ftabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nomor", "Nama", "Jenis Kelamin", "Kelas", "Tanggal Lahir", "Alamat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ftabel.setDoubleBuffered(true);
        ftabel.setDragEnabled(true);
        ftabel.setFillsViewportHeight(true);
        ftabel.setFocusCycleRoot(true);
        ftabel.setSurrendersFocusOnKeystroke(true);
        ftabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ftabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ftabel);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("FORM INPUTAN");

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Masukkan data Anda");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAMA");

        nama1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMOR");

        nomor1.setBackground(new java.awt.Color(0, 204, 204));
        nomor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomor1ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("JENIS KELAMIN");

        jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("KELAS");

        kelas1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X RPL 1", "X RPL 2", "X RPL 3", "X RPL 4", "X RPL 5", "X RPL 6", "X TKJ 1", "X TKJ 2", "X TKJ 3", "X TKJ 4", "X TKJ 5", "X TKJ 6", "XI RPL 1", "XI RPL 2", "XI RPL 3", "XI RPL 4 ", "XI RPL 5", "XI RPL 6", "XI TKJ 1", "XI TKJ 2", "XI TKJ 3", "XI TKJ 4", "XI TKJ 5", "XI TKJ 6", "XII RPL 1", "XII RPL 2", "XII RPL 3", "XII RPL 4", "XII RPL 5", "XII RPL 6", "XII TKJ 1", "XII TKJ 2", "XII TKJ 3", "XII TKJ 4", "XII TKJ 5", "XII TKJ 6" }));
        kelas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas1ActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TANGGAL LAHIR");

        tgl.setBackground(new java.awt.Color(255, 153, 153));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ALAMAT");

        alamat1.setBackground(new java.awt.Color(0, 204, 204));
        alamat1.setColumns(20);
        alamat1.setRows(5);
        jScrollPane2.setViewportView(alamat1);

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\SMK TELKOM MALANG\\KELAS XI\\PBO\\java\\Biodata\\src\\Gambar\\save.png")); // NOI18N
        jButton1.setText("SIMPAN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 153));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("D:\\SMK TELKOM MALANG\\KELAS XI\\PBO\\java\\Biodata\\src\\Gambar\\icon.png")); // NOI18N
        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 153));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon("D:\\SMK TELKOM MALANG\\KELAS XI\\PBO\\java\\Biodata\\src\\Gambar\\rubbish-bin.png")); // NOI18N
        jButton3.setText("HAPUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 153));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon("D:\\SMK TELKOM MALANG\\KELAS XI\\PBO\\java\\Biodata\\src\\Gambar\\store-new-badges.png")); // NOI18N
        jButton4.setText("BARU");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 153));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon("D:\\SMK TELKOM MALANG\\KELAS XI\\PBO\\java\\Biodata\\src\\Gambar\\exit.png")); // NOI18N
        jButton5.setText("KELUAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomor1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(nama1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kelas1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jk, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tgl, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nomor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton4)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kelas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(280, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(204, 204, 204)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(jLabel9)
                    .addContainerGap(421, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomor1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(nama1.getText().equals("")||nomor1.getText().equals("")
          ||jk.getSelectedItem().equals(null)||kelas1.getSelectedItem().equals(null)
          ||tgl.getDate().equals(null)||alamat1.getText().equals(""))
          
        {
JOptionPane.showMessageDialog(null, "Masukkan data diri anda dahulu !");
    return;
} else
{
   
        simpan();}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        edit();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        hapus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       baru();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        MenuUtama zz;
        zz = new MenuUtama();
        zz.setVisible(true); //merupakan fungsi untuk mengatur output agar dapat ditampilkan.
       this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void kelas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelas1ActionPerformed

    private void ftabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ftabelMouseClicked
        setTabel();
    }//GEN-LAST:event_ftabelMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inputan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inputan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inputan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inputan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Inputan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Inputan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTable ftabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jk;
    private javax.swing.JComboBox<String> kelas1;
    private javax.swing.JTextField nama1;
    private javax.swing.JTextField nomor1;
    private com.toedter.calendar.JDateChooser tgl;
    // End of variables declaration//GEN-END:variables

    private void BacaTabel() throws SQLException {
     
        try {
            con.ss=(Statement) con.cc.createStatement();
            String sql ="Select *from inputan order By Tnomor";
            con.rs = con.ss.executeQuery(sql);
            ResultSetMetaData m = con.rs.getMetaData();
            int kolom = m.getColumnCount();
            int baris = 0;
            while(con.rs.next()){
                baris = con.rs.getRow();
            }
            TblBiodata = new Object [baris] [kolom];
            int x =0;
            con.rs.beforeFirst();
            while(con.rs.next()){
                TblBiodata [x] [0] = con.rs.getString("Tnama");
                TblBiodata [x] [1] = con.rs.getString("Tnomor");
                TblBiodata [x] [2] = con.rs.getString("Tjeniskelamin");
                TblBiodata [x] [3] = con.rs.getString("Tkelas");
                TblBiodata [x] [4] = con.rs.getDate("Ttanggallahir");
                TblBiodata [x] [5] = con.rs.getString("Talamat");
                x++;  
            }
            ftabel.setModel(new DefaultTableModel(TblBiodata,label));
        }catch (Exception e){  
            JOptionPane.showMessageDialog(null, e);
            
        }
        
        //DefaultTabelModel Adalah class yang Digunakan untuk memberikan header dan data pada kolo man baris tabel
        //new DefaultTableModel(null,judul),kode ini berarti memberikan aray string judul menjadi header pada tabl dan
        // dan mebuat kosong  kolom-kolom pada tabel.

        //Fungsi resulset disini akan digunakan saat kita menggunakan statement select ke database, 
        //lebih jelasnya resultset adalah pengontrol letak kursor terhadap suatu baris didalam database, 
        //sehingga apa yg kita pilih
    }

    private void setTabel() {
        int row = ftabel.getSelectedRow();
        nama1.setText((String)ftabel.getValueAt(row,0));
        nomor1.setText((String)ftabel.getValueAt(row,1));
        jk.setSelectedItem((String)ftabel.getValueAt(row,2));
        kelas1.setSelectedItem((String)ftabel.getValueAt(row,3));
        tgl.setDate((Date)ftabel.getValueAt(row,4));
        alamat1.setText((String)ftabel.getValueAt(row,5));
        
        
        //Object merupakan objek yang akan kita masukkan pada tabel (Isi tabel).
        //Row merupakan baris dimana kita akan menyimpan data di tabel.
        //Coumn merupakan kolom dimana kita akan menyimpan data objek pada tabel. 
        //Nilai column di JTabel dimulai dari 0 (kolom paling kiri).
    }
    
}
