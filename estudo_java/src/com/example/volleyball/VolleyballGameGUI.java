import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class VolleyballGameGUI extends JFrame {

    private JTextField playerOneNameField, playerTwoNameField;
    private JLabel scoreLabel, messageLabel, courtLabel;
    private JButton attackDiagonalButton, attackParallelButton, attackShortDiagonalButton;
    private JButton blockDiagonalButton, blockParallelButton, blockShortDiagonalButton;
    private String playerOne, playerTwo, currentPlayer, currentDefender;
    private int pointsOne = 0, pointsTwo = 0;
    private int attackType = -1; // Inicialmente nenhum ataque foi feito

    public VolleyballGameGUI() {
        // Configuração da Janela Principal
        setTitle("Jogo de Vôlei");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior para os nomes dos jogadores e botão de início
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 2));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.setBackground(new Color(173, 216, 230));  // Azul claro, remetendo ao céu

        playerOneNameField = new JTextField("Jogador 1");
        playerTwoNameField = new JTextField("Jogador 2");

        topPanel.add(new JLabel("Nome do Jogador 1:"));
        topPanel.add(playerOneNameField);
        topPanel.add(new JLabel("Nome do Jogador 2:"));
        topPanel.add(playerTwoNameField);

        JButton startButton = new JButton("Iniciar Jogo");
        startButton.addActionListener(new StartButtonListener());
        topPanel.add(startButton);

        scoreLabel = new JLabel("Placar: 0 x 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 24));
        topPanel.add(scoreLabel);

        add(topPanel, BorderLayout.NORTH);

        // Painel central para a quadra e os botões de ataque e bloqueio
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.setBackground(new Color(255, 228, 196));  // Cor areia, remetendo à quadra de vôlei

        // Painel da quadra de vôlei com a imagem de fundo
        JPanel courtPanel = new JPanel();
        courtPanel.setLayout(new GridLayout(1, 2));

        // Adiciona a imagem de fundo da quadra
        URL imageUrl = getClass().getResource("/resources/volei.jpg"); // Caminho para a imagem
        ImageIcon courtIcon = new ImageIcon(imageUrl);
        courtLabel = new JLabel(courtIcon);
        courtLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        courtPanel.add(courtLabel);

        centerPanel.add(courtPanel, BorderLayout.CENTER);

        // Painel inferior para os botões de ataque e bloqueio
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2, 3));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        attackDiagonalButton = new JButton("Atacar na Diagonal");
        attackDiagonalButton.addActionListener(new AttackButtonListener(1));
        bottomPanel.add(attackDiagonalButton);

        attackParallelButton = new JButton("Atacar na Paralela");
        attackParallelButton.addActionListener(new AttackButtonListener(2));
        bottomPanel.add(attackParallelButton);

        attackShortDiagonalButton = new JButton("Atacar na Diagonal Curta");
        attackShortDiagonalButton.addActionListener(new AttackButtonListener(3));
        bottomPanel.add(attackShortDiagonalButton);

        blockDiagonalButton = new JButton("Bloquear na Diagonal");
        blockDiagonalButton.addActionListener(new BlockButtonListener(1));
        bottomPanel.add(blockDiagonalButton);

        blockParallelButton = new JButton("Bloquear na Paralela");
        blockParallelButton.addActionListener(new BlockButtonListener(2));
        bottomPanel.add(blockParallelButton);

        blockShortDiagonalButton = new JButton("Bloquear na Diagonal Curta");
        blockShortDiagonalButton.addActionListener(new BlockButtonListener(3));
        bottomPanel.add(blockShortDiagonalButton);

        centerPanel.add(bottomPanel, BorderLayout.SOUTH);

        messageLabel = new JLabel("Pressione 'Iniciar Jogo' para começar", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Serif", Font.BOLD, 18));
        centerPanel.add(messageLabel, BorderLayout.NORTH);

        add(centerPanel, BorderLayout.CENTER);

        // Inicialmente, botões de ataque e bloqueio estão desativados
        setButtonsEnabled(false);
    }

    private void setButtonsEnabled(boolean enabled) {
        attackDiagonalButton.setEnabled(enabled);
        attackParallelButton.setEnabled(enabled);
        attackShortDiagonalButton.setEnabled(enabled);
        blockDiagonalButton.setEnabled(enabled);
        blockParallelButton.setEnabled(enabled);
        blockShortDiagonalButton.setEnabled(enabled);
    }

    private void startGame() {
        playerOne = playerOneNameField.getText();
        playerTwo = playerTwoNameField.getText();
        currentPlayer = playerOne;
        currentDefender = playerTwo;
        pointsOne = 0;
        pointsTwo = 0;
        attackType = -1; // Resetar o tipo de ataque ao iniciar o jogo
        updateScore();
        messageLabel.setText(currentPlayer + " ataca primeiro!");
        setButtonsEnabled(true);
    }

    private void updateScore() {
        scoreLabel.setText(playerOne + " " + pointsOne + " x " + pointsTwo + " " + playerTwo);
    }

    private void checkWinner() {
        if (pointsOne >= 10) {
            JOptionPane.showMessageDialog(this, playerOne + " venceu o jogo!");
            messageLabel.setText(playerOne + " venceu o jogo!");
            setButtonsEnabled(false);
        } else if (pointsTwo >= 10) {
            JOptionPane.showMessageDialog(this, playerTwo + " venceu o jogo!");
            messageLabel.setText(playerTwo + " venceu o jogo!");
            setButtonsEnabled(false);
        } else {
            // Troca de papéis: quem fez o ponto ataca na próxima rodada
            String temp = currentPlayer;
            currentPlayer = currentDefender;
            currentDefender = temp;
            messageLabel.setText(currentPlayer + " está atacando!");
            setButtonsEnabled(true);  // Reativar botões de ataque e bloqueio
        }
    }

    private void showPointPopup(String player, String pointType) {
        JOptionPane.showMessageDialog(this, player + " fez um ponto de " + pointType + "!");
    }

    // Listeners para os botões
    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startGame();
        }
    }

    private class AttackButtonListener implements ActionListener {
        private int attackType;

        public AttackButtonListener(int attackType) {
            this.attackType = attackType;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VolleyballGameGUI.this.attackType = this.attackType; // Atualiza o ataqueType global
            setButtonsEnabled(false); // Desativa os botões de ataque temporariamente
            messageLabel.setText(currentDefender + ", escolha como bloquear.");
            blockDiagonalButton.setEnabled(true);
            blockParallelButton.setEnabled(true);
            blockShortDiagonalButton.setEnabled(true);
        }
    }

    private class BlockButtonListener implements ActionListener {
        private int blockType;

        public BlockButtonListener(int blockType) {
            this.blockType = blockType;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean blockSuccessful = (blockType == attackType); // Verifica se o bloqueio foi bem-sucedido
            if (blockSuccessful) {
                // Ponto para o defensor
                if (currentPlayer.equals(playerOne)) {
                    pointsTwo++;
                    showPointPopup(currentDefender, "bloqueio");
                    messageLabel.setText(currentDefender + " bloqueou com sucesso!");
                } else {
                    pointsOne++;
                    showPointPopup(currentDefender, "bloqueio");
                    messageLabel.setText(currentDefender + " bloqueou com sucesso!");
                }
            } else {
                // Ponto para o atacante
                if (currentPlayer.equals(playerOne)) {
                    pointsOne++;
                    showPointPopup(currentPlayer, "ataque");
                    messageLabel.setText(currentPlayer + " fez o ponto!");
                } else {
                    pointsTwo++;
                    showPointPopup(currentPlayer, "ataque");
                    messageLabel.setText(currentPlayer + " fez o ponto!");
                }
            }
            updateScore();
            checkWinner();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VolleyballGameGUI gameGUI = new VolleyballGameGUI();
            gameGUI.setVisible(true);
        });
    }
}
