
package hanoi;

import hanoi.backend.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Classe gérant le démarrage, l'affichage et les interractions avec l'utilisateur.
 * 
 * @author Raphaël Sylvain
 * @author Pierre-Olivier Boulet
 * 
 * @since 26/09/2013
 * 
 */
public class HanoiGame extends Application
{

    private Group root;
    private Scene inGame;
    private Scene startingMenu;

    // Constantes pour régler les contrôles d'affichage
    final int[] POSITION_X = { 150, 460, 760 };
    final int POSITION_Y = 280;
    final int PRIMARY_WIDTH_START = 400;
    final int PRIMARY_HEIGHT_START = 200;
    final int CB_DISKNUMBER_X = 280;
    final int CB_DISKNUMBER_Y = 75;
    final int WELCOMETEXT_X = 15;
    final int NBDISCS_X = 100;
    final int NBDISCS_Y = 80;
    final int BTN_START_X = 200;
    final int BTN_START_Y = 120;
    final int RECTANGLE_START_WIDTH = 375;
    final int RECTANGLE_START_HEIGHT = 160;
    final int RECTANGLE_START_X = 10;
    final int RECTANGLE_START_Y = 5;

    final int PRIMARY_WIDTH_INGAME = 1000;
    final int PRIMARY_HEIGHT_INGAME = 400;
    final int PRIMARY_X = 200;
    final int PRIMARY_Y = 150;

    final int BTN_RESTART_X = 880;
    final int TIMETEXT_X = 5;
    final int NBMOVESTEXT_X = 5;
    final int VICTORYTEXT_X = 270;
    final int INVALIDMOVE_X = 270;

    final int BTN_RESTART_Y = 15;
    final int TIMETEXT_Y = 60;
    final int NBMOVESTEXT_Y = 90;
    final int VICTORYTEXT_Y = 15;

    final int BUTTON_DISTANCE_X = 50; // Donne la distance entre les boutons

    private Label lblWelcome = new Label("Hanoi");
    private Label lblNbDiscs = new Label("Choisissez un nombre de disques");
    private Rectangle rectangleStart = new Rectangle();

    private Label lblInGame = new Label("Hanoi");
    private Label lblInvalidMove = new Label("");
    private Label lblTime = new Label("Temps de jeu: 0 s");
    private Label lblVictory = new Label("Victoire!");
    private Label lblVictoryMessage = new Label("Félicitations, vous avez prouvé la justice de notre culture!");
    private Label lblNbMoves = new Label("Nombre de coups: ");

    private Boolean visibleInGameText = true;

    private Button btnRestart = new Button("Recommencer");
    private Button btnTower1Right = new Button(">");
    private Button btnTower1DoubleRight = new Button(">>");
    private Button btnTower2Left = new Button("<");
    private Button btnTower2Right = new Button(">");
    private Button btnTower3DoubleLeft = new Button("<<");
    private Button btnTower3Left = new Button("<");

    private Timeline timelineInGame;
    private Timeline timelineErrorMessage;
    private Boolean timerActivated = true;

    private int time = 0;
    private int nbDiscsTotal = 0;
    private int nbMoves = -1;

    private Pole poles[] = new Pole[3];

    public static void main(String[] args)
    {
	Application.launch(HanoiGame.class, args);
    }

    /**
     * Main de Hanoi. Il vérifie que certaines classes ne lance pas de méthode puis démarre l'application.
     */
    @Override
    public void start(Stage primaryStage)
    {

	// Result result = new Result();

	// result = org.junit.runner.JUnitCore.runClasses(NodeTest.class, StackTest.class, GameTest.class, TowerTest.class);
	// {
	primaryStage.setTitle("Hanoi - Raphaël Sylvain et Pierre-Olivier Boulet");

	primaryStage.setResizable(false);

	this.timelineInGame = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>()
	{
	    @Override
	    public void handle(ActionEvent event)
	    {

		if (timerActivated)
		{
		    ++time;
		    if (time < 999)
		    {
			lblTime.setText("Temps de jeu: " + Integer.toString(time) + "s");
		    }
		    else
		    {
			lblTime.setText("On lâche pas!");
		    }

		    if (visibleInGameText == true)
		    {
			visibleInGameText = false;
		    }
		    else
		    {
			visibleInGameText = true;
		    }
		    lblInGame.setVisible(visibleInGameText);
		}
	    }
	}));

	this.timelineInGame.setCycleCount(Timeline.INDEFINITE);
	this.timelineInGame.play();

	startingMenu(primaryStage);
    }

    // }

    /**
     * Fonction qui gère l'affichage de la première fenêtre.
     * 
     * @param primaryStage
     *            La fenêtre.
     */
    private void startingMenu(final Stage primaryStage)
    {
	this.root = new Group();
	this.startingMenu = new Scene(this.root);

	this.startingMenu.setFill(Color.rgb(172, 255, 115));

	primaryStage.setWidth(this.PRIMARY_WIDTH_START);
	primaryStage.setHeight(this.PRIMARY_HEIGHT_START);

	final ComboBox<Integer> cbSelectDiscNumber = new ComboBox<Integer>();

	cbSelectDiscNumber.getItems().addAll(3, 4, 5);
	cbSelectDiscNumber.getSelectionModel().select(0);
	cbSelectDiscNumber.setTranslateX(this.CB_DISKNUMBER_X);
	cbSelectDiscNumber.setTranslateY(this.CB_DISKNUMBER_Y);

	this.lblWelcome.setFont(new Font("Forte", 60));
	this.lblWelcome.setTranslateX(this.WELCOMETEXT_X);
	this.lblWelcome.setTextFill(Color.FIREBRICK);
	this.lblNbDiscs.setTranslateX(this.NBDISCS_X);
	this.lblNbDiscs.setTranslateY(this.NBDISCS_Y);

	this.rectangleStart.setStroke(Color.FIREBRICK);
	this.rectangleStart.setFill(Color.TRANSPARENT);
	this.rectangleStart.setStrokeWidth(2);
	this.rectangleStart.setWidth(this.RECTANGLE_START_WIDTH);
	this.rectangleStart.setHeight(this.RECTANGLE_START_HEIGHT);
	this.rectangleStart.setTranslateX(this.RECTANGLE_START_X);
	this.rectangleStart.setTranslateY(this.RECTANGLE_START_Y);

	Button btnStart = new Button("Commencer la partie!");

	btnStart.setOnAction(new EventHandler<ActionEvent>()
	{
	    @Override
	    public void handle(ActionEvent e)
	    {

		nbDiscsTotal = (int) cbSelectDiscNumber.getValue();
		inGame(primaryStage, nbDiscsTotal);
	    }
	});

	btnStart.setTranslateX(this.BTN_START_X);
	btnStart.setTranslateY(this.BTN_START_Y);

	this.root.getChildren().add(this.lblWelcome);
	root.getChildren().add(this.lblNbDiscs);
	root.getChildren().add(this.rectangleStart);
	this.root.getChildren().add(btnStart);
	this.root.getChildren().add(cbSelectDiscNumber);

	primaryStage.setScene(this.startingMenu);
	primaryStage.show();
    }

    /**
     * Fonction qui gère l'affichage de la fenêtre de jeu.
     * 
     * @param primaryStage
     *            La fenêtre.
     * @param discNumber
     *            Le nombre de disque qu'il y aura dans le jeu.
     */
    private void inGame(Stage primaryStage, int discNumber)
    {
	this.root = new Group();
	this.inGame = new Scene(this.root);

	this.inGame.setFill(Color.rgb(172, 255, 115));

	this.timerActivated = true;
	this.lblTime.setText("Temps de jeu: 0s");
	this.btnTower1Right.setDisable(false);
	this.btnTower1DoubleRight.setDisable(false);
	this.btnTower2Left.setDisable(false);
	this.btnTower2Right.setDisable(false);
	this.btnTower3DoubleLeft.setDisable(false);
	this.btnTower3Left.setDisable(false);

	this.time = 0;

	primaryStage.setWidth(this.PRIMARY_WIDTH_INGAME);
	primaryStage.setHeight(this.PRIMARY_HEIGHT_INGAME);
	primaryStage.setX(this.PRIMARY_X);
	primaryStage.setY(this.PRIMARY_Y);

	Game game = new Game(discNumber);

	this.poles[0] = new Pole(1, game.GetTower(0));
	this.poles[1] = new Pole(2, game.GetTower(1));
	this.poles[2] = new Pole(3, game.GetTower(2));

	this.ContentBar(game, primaryStage);
	this.refreshPoles(game, primaryStage);

	primaryStage.setScene(this.inGame);
	primaryStage.show();
    }

    /**
     * Fonction qui crée l'affichage des trois pôles.
     * 
     * @param game
     *            Le jeu à afficher.
     * @param primaryStage
     *            La fenêtre.
     */
    public void refreshPoles(Game game, final Stage primaryStage)
    {

	this.root.getChildren().add(this.poles[0]);
	this.root.getChildren().add(this.poles[1]);
	this.root.getChildren().add(this.poles[2]);

	if (game.GetTower(2).IsCompleted(this.nbDiscsTotal))
	{
	    this.timerActivated = false;
	    this.timelineInGame = null;

	    this.lblInGame.setText("");
	    this.btnTower1Right.setDisable(true);
	    this.btnTower1DoubleRight.setDisable(true);
	    this.btnTower2Left.setDisable(true);
	    this.btnTower2Right.setDisable(true);
	    this.btnTower3DoubleLeft.setDisable(true);
	    this.btnTower3Left.setDisable(true);

	    this.root.getChildren().add(this.lblVictory);
	    this.root.getChildren().add(this.lblVictoryMessage);

	}

	this.nbMoves++;
	this.lblNbMoves.setText("Nombre de coups: " + Integer.toString(this.nbMoves));

	primaryStage.setScene(this.inGame);
	primaryStage.show();
    }

    /**
     * Fonction qui crée les différents boutons et labels dans la fenêtre de jeu.
     * 
     * @param currentGame
     *            La partie à appliquer des modifications.
     * @param primaryStage
     *            La fenêtre.
     */
    public void ContentBar(final Game currentGame, final Stage primaryStage)
    {
	this.lblInGame.setFont(Font.font("Verdana", FontWeight.BOLD, 48));
	this.lblTime.setFont(new Font("ARIAL", 18));
	this.lblNbMoves.setFont(new Font("ARIAL", 18));
	this.lblVictory.setFont(new Font("Forte", 60));
	this.lblVictoryMessage.setFont(new Font("Forte", 20));
	this.lblInvalidMove.setFont(new Font("ARIAL", 18));

	this.lblInGame.setTextFill(Color.RED);
	this.lblVictory.setTextFill(Color.GOLD);
	this.lblInvalidMove.setTextFill(Color.RED);

	this.btnRestart.setTranslateX(this.BTN_RESTART_X);
	this.lblTime.setTranslateX(this.TIMETEXT_X);
	this.lblNbMoves.setTranslateX(this.NBMOVESTEXT_X);
	this.lblVictoryMessage.setTranslateX(this.VICTORYTEXT_X);
	this.lblInvalidMove.setTranslateX(this.INVALIDMOVE_X);

	this.btnTower1Right.setTranslateX(this.POSITION_X[0]);
	this.btnTower1DoubleRight.setTranslateX(this.POSITION_X[0] + this.BUTTON_DISTANCE_X);
	this.btnTower2Left.setTranslateX(this.POSITION_X[1]);
	this.btnTower2Right.setTranslateX(this.POSITION_X[1] + this.BUTTON_DISTANCE_X);
	this.btnTower3DoubleLeft.setTranslateX(this.POSITION_X[2]);
	this.btnTower3Left.setTranslateX(this.POSITION_X[2] + this.BUTTON_DISTANCE_X);

	this.btnRestart.setTranslateY(this.BTN_RESTART_Y);
	this.lblTime.setTranslateY(this.TIMETEXT_Y);
	this.lblNbMoves.setTranslateY(this.NBMOVESTEXT_Y);
	this.lblVictoryMessage.setTranslateY(this.VICTORYTEXT_Y);
	this.lblInvalidMove.setTranslateY(this.POSITION_Y + 20);

	this.btnTower1Right.setTranslateY(this.POSITION_Y);
	this.btnTower1DoubleRight.setTranslateY(this.POSITION_Y);
	this.btnTower2Left.setTranslateY(this.POSITION_Y);
	this.btnTower2Right.setTranslateY(this.POSITION_Y);
	this.btnTower3DoubleLeft.setTranslateY(this.POSITION_Y);
	this.btnTower3Left.setTranslateY(this.POSITION_Y);

	this.root.getChildren().add(this.lblInGame);
	this.root.getChildren().add(this.lblTime);
	this.root.getChildren().add(this.lblNbMoves);
	this.root.getChildren().add(this.lblInvalidMove);

	this.root.getChildren().add(this.btnRestart);

	this.root.getChildren().add(this.btnTower1Right);
	this.root.getChildren().add(this.btnTower1DoubleRight);
	this.root.getChildren().add(this.btnTower2Left);
	this.root.getChildren().add(this.btnTower2Right);
	this.root.getChildren().add(this.btnTower3Left);
	this.root.getChildren().add(this.btnTower3DoubleLeft);

	this.btnRestart.setOnAction(new EventHandler<ActionEvent>()
	{
	    @Override
	    public void handle(ActionEvent e)
	    {
		// Afin de ne pas avoir à attendre un tick de timer pour qu'il soit remis à zéro.
		// Automatique dès que l'on clique sur le bouton restart.
		nbMoves = -1;

		startingMenu(primaryStage);
	    }
	});

	this.btnTower1Right.setOnAction(new EventHandler<ActionEvent>()
	{
	    @Override
	    public void handle(ActionEvent e)
	    {
		if (currentGame.Move(0, 1))
		{
		    root.getChildren().remove(poles[0]);
		    root.getChildren().remove(poles[1]);
		    root.getChildren().remove(poles[2]);
		    poles[0] = new Pole(1, currentGame.GetTower(0));
		    poles[1] = new Pole(2, currentGame.GetTower(1));
		    poles[2] = new Pole(3, currentGame.GetTower(2));

		    refreshPoles(currentGame, primaryStage);
		}
		else
		{
		    showErrorMessage();
		}
	    }
	});

	this.btnTower1DoubleRight.setOnAction(new EventHandler<ActionEvent>()
	{
	    @Override
	    public void handle(ActionEvent e)
	    {
		if (currentGame.Move(0, 2))
		{
		    root.getChildren().remove(poles[0]);
		    root.getChildren().remove(poles[1]);
		    root.getChildren().remove(poles[2]);
		    poles[0] = new Pole(1, currentGame.GetTower(0));
		    poles[1] = new Pole(2, currentGame.GetTower(1));
		    poles[2] = new Pole(3, currentGame.GetTower(2));

		    refreshPoles(currentGame, primaryStage);
		}
		else
		{
		    showErrorMessage();
		}
	    }
	});

	this.btnTower2Left.setOnAction(new EventHandler<ActionEvent>()
	{
	    @Override
	    public void handle(ActionEvent e)
	    {
		if (currentGame.Move(1, 0))
		{
		    root.getChildren().remove(poles[0]);
		    root.getChildren().remove(poles[1]);
		    root.getChildren().remove(poles[2]);
		    poles[0] = new Pole(1, currentGame.GetTower(0));
		    poles[1] = new Pole(2, currentGame.GetTower(1));
		    poles[2] = new Pole(3, currentGame.GetTower(2));

		    refreshPoles(currentGame, primaryStage);
		}
		else
		{
		    showErrorMessage();
		}
	    }
	});

	this.btnTower2Right.setOnAction(new EventHandler<ActionEvent>()
	{
	    @Override
	    public void handle(ActionEvent e)
	    {
		if (currentGame.Move(1, 2))
		{
		    root.getChildren().remove(poles[0]);
		    root.getChildren().remove(poles[1]);
		    root.getChildren().remove(poles[2]);
		    poles[0] = new Pole(1, currentGame.GetTower(0));
		    poles[1] = new Pole(2, currentGame.GetTower(1));
		    poles[2] = new Pole(3, currentGame.GetTower(2));

		    refreshPoles(currentGame, primaryStage);
		}
		else
		{
		    showErrorMessage();
		}
	    }
	});

	this.btnTower3Left.setOnAction(new EventHandler<ActionEvent>()
	{
	    @Override
	    public void handle(ActionEvent e)
	    {
		if (currentGame.Move(2, 1))
		{
		    root.getChildren().remove(poles[0]);
		    root.getChildren().remove(poles[1]);
		    root.getChildren().remove(poles[2]);
		    poles[0] = new Pole(1, currentGame.GetTower(0));
		    poles[1] = new Pole(2, currentGame.GetTower(1));
		    poles[2] = new Pole(3, currentGame.GetTower(2));

		    refreshPoles(currentGame, primaryStage);
		}
		else
		{
		    showErrorMessage();
		}

	    }
	});

	this.btnTower3DoubleLeft.setOnAction(new EventHandler<ActionEvent>()
	{
	    @Override
	    public void handle(ActionEvent e)
	    {
		if (currentGame.Move(2, 0))
		{
		    root.getChildren().remove(poles[0]);
		    root.getChildren().remove(poles[1]);
		    root.getChildren().remove(poles[2]);
		    poles[0] = new Pole(1, currentGame.GetTower(0));
		    poles[1] = new Pole(2, currentGame.GetTower(1));
		    poles[2] = new Pole(3, currentGame.GetTower(2));

		    refreshPoles(currentGame, primaryStage);
		}
		else
		{
		    showErrorMessage();
		}

	    }
	});
    }

    /**
     * Affichage d'un message d'erreur lorsqu'il y a un mouvement invalide.
     */
    private void showErrorMessage()
    {
	this.lblInvalidMove.setText("Vous ne pouvez déplacer un disque sur un autre disque plus petit");

	this.timelineErrorMessage = new Timeline(new KeyFrame(Duration.millis(4000), new EventHandler<ActionEvent>()
	{
	    @Override
	    public void handle(ActionEvent event)
	    {
		lblInvalidMove.setText("");
	    }
	}));

	this.timelineErrorMessage.setCycleCount(1);
	this.timelineErrorMessage.play();

    }
}
