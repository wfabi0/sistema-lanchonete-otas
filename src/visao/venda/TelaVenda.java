/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.venda;

import controller.FormaPagamentoController;
import controller.ItemNFVendaController;
import controller.NFVendaController;
import controller.NFVendaPagamentoController;
import controller.ProdutoController;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ItemNFVenda;
import model.NFVenda;
import model.FormaPagamento;
import model.NFVendaPagamento;
import model.Produto;
import visao.usuario.TelaMenu;

/**
 *
 * @author 0077110
 */
public class TelaVenda extends javax.swing.JFrame {

    private List<ItemNFVenda> itensNFVenda;
    private Double valorTotal;

    /**
     * Creates new form venda
     */
    public TelaVenda() {
        initComponents();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tableItensNF.getColumnCount(); i++) {
            tableItensNF.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        setTitle("Lanchonete Ota's - Tela Venda");
        setLocationRelativeTo(null);
        this.atualizarTela();
    }

    public TelaVenda(List<ItemNFVenda> itensNFVenda) {
        initComponents();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < tableItensNF.getColumnCount(); i++) {
            tableItensNF.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        setTitle("Lanchonete Ota's - Venda");
        setLocationRelativeTo(null);
        this.itensNFVenda = itensNFVenda;
        this.atualizarTela();
    }

    private void atualizarTela() {
        preencherTabela();
        atualizarData();
    }

    private void limparTela() {
        atualizarData();
        DefaultTableModel model = (DefaultTableModel) tableItensNF.getModel();
        model.setNumRows(0);
        txtCodigoProduto.setText("");
        txtVendaCpfCliente.setText("");
        valorTotal = 0.0;
        infoTotal.setText(formatarValor(valorTotal));
        itensNFVenda.clear();
    }

    private void preencherTabela() {
        valorTotal = 0.0;
        DefaultTableModel model = (DefaultTableModel) tableItensNF.getModel();
        model.setNumRows(0);
        try {
            if (itensNFVenda == null) {
                return;
            }
            if (!itensNFVenda.isEmpty()) {
//                NFVenda nfVenda = new NFVenda();
                for (ItemNFVenda itemNFVenda : itensNFVenda) {
                    Object[] obj = {
                        itemNFVenda.getCodigo_produto(),
                        itemNFVenda.getProduto().getNome(),
                        itemNFVenda.getProduto().getValor(),
                        itemNFVenda.getQuantidade(),
                        itemNFVenda.getValor_total()
                    };
                    valorTotal += itemNFVenda.getValor_total();
                    model.addRow(obj);
                }
            } else {
                tableItensNF.setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        infoTotal.setText(formatarValor(valorTotal));
    }

    private void atualizarData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        ZonedDateTime nowInBrazil = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        String formattedDate = nowInBrazil.format(formatter);
        infoData.setText(formattedDate);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollBar2 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtVendaCpfCliente = new javax.swing.JTextField();
        infoData = new javax.swing.JLabel();
        txtCodigoProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscarProduto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItensNF = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        infoTotal = new javax.swing.JLabel();
        btnVoltarMenu = new javax.swing.JButton();
        btnEmitirNF = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbMetodoPagamento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lanchonete Ota's - Venda");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CPF Cliente");

        infoData.setText("data");

        txtCodigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProdutoKeyPressed(evt);
            }
        });

        jLabel3.setText("Insira o codigo do Produto");

        btnBuscarProduto.setText("...");
        btnBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProdutoActionPerformed(evt);
            }
        });

        tableItensNF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Preço", "Quantidade", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableItensNF);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Total:");

        infoTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        infoTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        infoTotal.setText("R$ 0");

        btnVoltarMenu.setText("Voltar");
        btnVoltarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarMenuActionPerformed(evt);
            }
        });

        btnEmitirNF.setText("Emitir NF");
        btnEmitirNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirNFActionPerformed(evt);
            }
        });

        jLabel5.setText("Pagamento");

        cbMetodoPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DIN", "CC", "CD", "PIX" }));
        cbMetodoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMetodoPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVendaCpfCliente)
                            .addComponent(txtCodigoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarProduto))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMetodoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(infoData))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnVoltarMenu)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnEmitirNF)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(infoTotal)
                                        .addComponent(jLabel4))
                                    .addGap(20, 20, 20))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoData, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtVendaCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbMetodoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVoltarMenu)
                            .addComponent(btnEmitirNF))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProdutoActionPerformed
        // TODO add your handling code here:
        if (itensNFVenda == null) {
            itensNFVenda = new ArrayList<>();
        }
        VendaProdutoConsultar vendaProdutoConsultar = new VendaProdutoConsultar(this, itensNFVenda);
        vendaProdutoConsultar.setVisible(true);
    }//GEN-LAST:event_btnBuscarProdutoActionPerformed

    private void btnVoltarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarMenuActionPerformed
        // TODO add your handling code here:
        TelaMenu telaMenu = new TelaMenu();
        this.setVisible(false);
        telaMenu.setVisible(true);
    }//GEN-LAST:event_btnVoltarMenuActionPerformed

    private void btnEmitirNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirNFActionPerformed
        // TODO add your handling code here:

        try {
            if (txtVendaCpfCliente.getText().isEmpty()) {
                // Cliente Padrão
                txtVendaCpfCliente.setText("000.000.000-00");
            }
            String cpfFormatado = txtVendaCpfCliente.getText().replaceAll("\\D", "");
            String regexCPF = "^\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}$";
            if (!Pattern.matches(regexCPF, txtVendaCpfCliente.getText())) {
                JOptionPane.showMessageDialog(this, "Você não inseriu um CPF válido.");
                return;
            }
            DefaultTableModel model = (DefaultTableModel) tableItensNF.getModel();
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Você não inseriu nenhum item na sua nota fiscal.");
                return;
            }
            String pagamento = (String) cbMetodoPagamento.getSelectedItem();
            FormaPagamentoController formaPagamentoController = new FormaPagamentoController();
            FormaPagamento formaPagamento = null;
            switch (pagamento) {
                case "DIN": {
                    formaPagamento = formaPagamentoController.procurarPorNome("Dinheiro");
                    break;
                }
                case "CC": {
                    formaPagamento = formaPagamentoController.procurarPorNome("Cartão de Crédito");
                    break;
                }
                case "CD": {
                    formaPagamento = formaPagamentoController.procurarPorNome("Cartão de Débito");
                    break;
                }
                case "PIX": {
                    formaPagamento = formaPagamentoController.procurarPorNome("Pix");
                    break;
                }
            }
            if (formaPagamento == null) {
                JOptionPane.showMessageDialog(this, "Um erro ocorreu, tente novamente.");
                return;
            }

            NFVendaController nfVendaController = new NFVendaController();
            NFVenda nfVenda = new NFVenda();

            NFVendaPagamentoController nfVendaPagamentoController = new NFVendaPagamentoController();
            NFVendaPagamento nfVendaPagamento = new NFVendaPagamento();

            ItemNFVendaController itemNFVendaController = new ItemNFVendaController();

            nfVenda.setCpfCliente(cpfFormatado);
            nfVenda.setItemsNFVenda(itensNFVenda);
            nfVenda.setDataEmissao(new Date(System.currentTimeMillis()));
            nfVenda.setValor(valorTotal);

            nfVenda = nfVendaController.inserir(nfVenda);

            nfVendaPagamento.setCodigo_nf(nfVenda.getCodigo());
            nfVendaPagamento.setCodigo_pagamento(formaPagamento.getTipo());

            nfVendaPagamento = nfVendaPagamentoController.inserir(nfVendaPagamento);

            for (ItemNFVenda itemNFVenda : itensNFVenda) {
                itemNFVenda.setCodigo_nf(nfVenda.getCodigo());
                itemNFVenda = itemNFVendaController.inserir(itemNFVenda);
            }

            System.out.println(nfVenda);
            System.out.println(nfVendaPagamento);
            JOptionPane.showMessageDialog(this, "Imprimindo comprovante...");
            limparTela();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Um erro ocorreu ao emitir a nota fisca.");
        }
    }//GEN-LAST:event_btnEmitirNFActionPerformed

    private void txtCodigoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProdutoKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            if (txtCodigoProduto.getText().isEmpty()) {
                return;
            }
            if (itensNFVenda == null) {
                itensNFVenda = new ArrayList<>();
            }
            try {
                int codigo = Integer.parseInt(txtCodigoProduto.getText());
                ProdutoController produtoController = new ProdutoController();
                List<Produto> produtos = produtoController.consultarPorCodigo(codigo);
                if (produtos.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado no sistema.");
                    return;
                }
                Produto produto = produtos.get(0);
                ItemNFVenda itemNFVenda = new ItemNFVenda();
                itemNFVenda.setCodigo(1);
                itemNFVenda.setCodigo_nf(0);
                itemNFVenda.setCodigo_produto(produto.getCodigo());
                itemNFVenda.setQuantidade(1);
                itemNFVenda.setValor_uni(produto.getValor());
                itemNFVenda.setValor_total(produto.getValor() * itemNFVenda.getQuantidade());
                itemNFVenda.setProduto(produto);
                itensNFVenda.add(itemNFVenda);
                atualizarTela();
                return;
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                ProdutoController produtoController = new ProdutoController();
                Produto produto = produtoController.consultarPorNome(txtCodigoProduto.getText()).get(0);
                ItemNFVenda itemNFVenda = new ItemNFVenda();
                itemNFVenda.setCodigo(1);
                itemNFVenda.setCodigo_nf(0);
                itemNFVenda.setCodigo_produto(produto.getCodigo());
                itemNFVenda.setQuantidade(1);
                itemNFVenda.setValor_uni(produto.getValor());
                itemNFVenda.setValor_total(produto.getValor() * itemNFVenda.getQuantidade());
                itemNFVenda.setProduto(produto);
                itensNFVenda.add(itemNFVenda);
                atualizarTela();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_txtCodigoProdutoKeyPressed

    private void cbMetodoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMetodoPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMetodoPagamentoActionPerformed

    private String formatarValor(Double valor) {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatoMoeda.format(valor);
    }

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
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProduto;
    private javax.swing.JButton btnEmitirNF;
    private javax.swing.JButton btnVoltarMenu;
    private javax.swing.JComboBox<String> cbMetodoPagamento;
    private javax.swing.JLabel infoData;
    private javax.swing.JLabel infoTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableItensNF;
    private javax.swing.JTextField txtCodigoProduto;
    private javax.swing.JTextField txtVendaCpfCliente;
    // End of variables declaration//GEN-END:variables

    public List<ItemNFVenda> getItensNFVenda() {
        return itensNFVenda;
    }

    public void setItensNFVenda(List<ItemNFVenda> itensNFVenda) {
        this.itensNFVenda = itensNFVenda;
        this.atualizarTela();
    }
}
