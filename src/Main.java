public class Main {
    public static void main(String[] args) {
        DataBaseManager database= new DataBaseManager();
        Game game = new Game(database);
        game.showWelcome();
    }
}