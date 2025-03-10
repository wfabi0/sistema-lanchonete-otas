package visao.usuario;

import controller.FuncionarioController;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;
import model.Funcionario;
import session.SessaoUsuario;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
//        try {
//            UIManager.setLookAndFeel(new FlatMacLightLaf());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        initComponents();
        setTitle("Lanchonete Ota's - Login");
        setLocationRelativeTo(null);
    }

    private void autenticar() {
        String usuario = txtLoginUsuario.getText();
        char[] senhaArray = txtLoginSenha.getPassword();
        String senha = new String(senhaArray);

        if (usuario.length() == 0 || senha.length() == 0) {
            JOptionPane.showMessageDialog(this, "Você precisa inserir o usuário e senha.");
            return;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(usuario);
        funcionario.setSenha(senha);

        FuncionarioController funcionarioController = new FuncionarioController();
        funcionario = funcionarioController.autenticar(funcionario);

        if (funcionario == null) {
            System.out.println(funcionario);
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválida.");
            return;
        }

//        JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
        TelaMenu telaMenu = new TelaMenu();
        telaMenu.setVisible(true);
        this.setVisible(false);

        SessaoUsuario.setAtributo("session", funcionario);
        Arrays.fill(senhaArray, ' ');
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtLoginUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnLoginEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtLoginSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuário:");

        txtLoginUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginUsuarioActionPerformed(evt);
            }
        });
        txtLoginUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginUsuarioKeyPressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Senha:");

        btnLoginEntrar.setText("Entrar");
        btnLoginEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginEntrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lanchonete Ota's - Login");

        txtLoginSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoginSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLoginEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtLoginSenha))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoginSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnLoginEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginUsuarioActionPerformed

    private void btnLoginEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginEntrarActionPerformed
        // TODO add your handling code here:
        this.autenticar();
    }//GEN-LAST:event_btnLoginEntrarActionPerformed

    private void txtLoginUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginUsuarioKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            this.autenticar();
        }
    }//GEN-LAST:event_txtLoginUsuarioKeyPressed

    private void txtLoginSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginSenhaKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            this.autenticar();
        }
    }//GEN-LAST:event_txtLoginSenhaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtLoginSenha;
    private javax.swing.JTextField txtLoginUsuario;
    // End of variables declaration//GEN-END:variables
}
