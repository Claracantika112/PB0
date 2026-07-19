import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplikasiBiodata extends JFrame {

    // Komponen Input
    private JTextField txtNim, txtNama, txtProdi;
    // Komponen Output
    private JTextArea txtOutput;
    // Tombol aksi
    private JButton btnTampilkan, btnReset;

    public AplikasiBiodata() {
        // Mengatur properti JFrame
        setTitle("Aplikasi Biodata Mahasiswa");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ================= PANEL INPUT =================
        JPanel panelInputOuter = new JPanel(new BorderLayout());
        panelInputOuter.setBorder(BorderFactory.createTitledBorder("Input Data"));
        
        JPanel panelInputGrid = new JPanel(new GridLayout(3, 2, 5, 10));
        
        panelInputGrid.add(new JLabel("NIM"));
        txtNim = new JTextField();
        panelInputGrid.add(txtNim);

        panelInputGrid.add(new JLabel("Nama"));
        txtNama = new JTextField();
        panelInputGrid.add(txtNama);

        panelInputGrid.add(new JLabel("Program Studi"));
        txtProdi = new JTextField();
        panelInputGrid.add(txtProdi);
        
        panelInputOuter.add(panelInputGrid, BorderLayout.CENTER);

        // ================= PANEL TOMBOL =================
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnTampilkan = new JButton("Tampilkan");
        btnReset = new JButton("Reset");
        
        panelTombol.add(btnTampilkan);
        panelTombol.add(btnReset);

        // Gabungkan Input dan Tombol di bagian atas (North)
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelInputOuter, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);

        // ================= PANEL OUTPUT =================
        JPanel panelOutput = new JPanel(new BorderLayout());
        panelOutput.setBorder(BorderFactory.createTitledBorder("Output"));
        
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Agar layout titik dua sejajar rapi
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        
        panelOutput.add(scrollPane, BorderLayout.CENTER);

        // Menambahkan komponen utama ke Frame
        add(panelAtas, BorderLayout.NORTH);
        add(panelOutput, BorderLayout.CENTER);

        // ================= LOGIK ASTRUKTUR (ACTION LISTENER) =================
        
        // 2. Logika ketika tombol Tampilkan diklik
        btnTampilkan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = txtNim.getText();
                String nama = txtNama.getText();
                String prodi = txtProdi.getText();
                
                String hasil = "========== BIODATA MAHASISWA ==========\n\n"
                             + "NIM           : " + nim + "\n"
                             + "Nama          : " + nama + "\n"
                             + "Program Studi : " + prodi;
                
                txtOutput.setText(hasil);
            }
        });

        // 3. Logika ketika tombol Reset diklik
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNim.setText("");
                txtNama.setText("");
                txtProdi.setText("");
                txtOutput.setText("");
            }
        });
    }

    public static void main(String[] args) {
        // Menjalankan GUI di thread yang aman
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AplikasiBiodata().setVisible(true);
            }
        });
    }
}