import java.util.*;


public class Main{
    public static void main(String[] args) {
        Cell[][] cells = new Cell[10][10];
        Key k1 = new Key("key1", 400);
        Key k2 = new Key("key2", 500);
        Key k3 = new Key("key3", 600);
        int chestPos = 5;
        int hollywater = 7;
        int acide = 9;
        
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (counter == chestPos) {
                    cells[i][j] = new Cell(new Chest(k1));
                } else if (counter == hollywater) {
                    cells[i][j] = new Cell(new HolyWater(20));
                } else if (counter == acide) {
                    cells[i][j] = new Cell(new Acid(10));
                } else {
                    cells[i][j] = new Cell(new Ground());
                }
                counter++;
            }
        }
        cells[2][0] = new Cell(new Wall());
        cells[3][0] = new Cell(new Wall());
        cells[5][0] = new Cell(new Wall());
        cells[6][0] = new Cell(new Wall());
        cells[7][0] = new Cell(new Wall());

        cells[2][1] = new Cell(new Wall());
        cells[3][1] = new Cell(new Wall());
        cells[5][1] = new Cell(new Wall());
        cells[6][1] = new Cell(new Wall());
        cells[7][1] = new Cell(new Wall());

        cells[2][2] = new Cell(new Wall());
        cells[3][2] = new Cell(new Wall());
        
        cells[2][3] = new Cell(new Wall());
        cells[3][3] = new Cell(new Wall());
        cells[5][3] = new Cell(new Wall());
        cells[6][3] = new Cell(new Wall());
        cells[7][3] = new Cell(new Wall());
        cells[8][3] = new Cell(new Wall());
        cells[9][3] = new Cell(new Wall());

        cells[1][6] = new Cell(new Wall());
        cells[2][6] = new Cell(new Wall());
        
        cells[5][4] = new Cell(new Wall());
        cells[0][4] = new Cell(new Wall());
        cells[0][6] = new Cell(new Wall());
        cells[2][5] = new Cell(new Wall());

        cells[0][8] = new Cell(new Wall());
        cells[1][8] = new Cell(new Wall());
        cells[2][8] = new Cell(new Wall());
        cells[3][8] = new Cell(new Wall());
        cells[4][8] = new Cell(new Wall());
        cells[5][8] = new Cell(new Wall());
        cells[6][8] = new Cell(new Wall());
        cells[7][8] = new Cell(new Wall());
        cells[9][8] = new Cell(new Wall());

        cells[4][0] = new Cell(new Game1());
        cells[9][2] = new Cell(new Game2());
        cells[9][9] = new Cell(new Game3());
        HealthBar healthBarM = new HealthBar("HealthBarM", 150, 200);
        cells[8][7] = new Cell(new Monster(healthBarM, 100));
        cells[7][7] = new Cell(new Kata());
        cells[6][6] = new Cell(new Dress1());
        cells[6][4] = new Cell(new Boots1());
        cells[2][7] = new Cell(new Monster(healthBarM, 100));
        Area areaOne = new Area(cells, "Area One");
        
        List<Area> areas = new ArrayList();

        areas.add(areaOne);
        
        World world = new World(areas);
        world.getAreaByName("Area One").getArea()[1][0].addTagible(new Acid(50));
        for(int i=0;i<40;i++)
                System.out.println("\n" ); 
        System.out.println("Welcome to the game Player ...");
        System.out.println("Press Enter to Start");
        new java.util.Scanner(System.in).nextLine();
        
        Stats stats = new Stats(100, 100);
        HealthBar healthBar = new HealthBar("HealthBar", 100, 200);
        List<Item> bag = new ArrayList<>();
        Player player = new Player("PlayerOne", 100, stats, healthBar, bag, 'J', new Position(0, 0, "Area One"));
        world.getAreaByName("Area One").getArea()[0][0].addTagible(player);
        int input = 0;
        while(input != 1){
            
                
            for(int i=0;i<40;i++)
                System.out.println("\n" ); 

            if(player.getPosition().getX() == 9 && player.getPosition().getY() == 9){
                for(int i=0;i<40;i++)
                    System.out.println("\n" );
                Hang g3 = new Hang("Hang",k3, k3);
                String var= "0";
                GameRunner gr3 = new GameRunner(player.getKey(),var);
                if(player.getKey().getName().equals(g3.getKeyCondition().getName()))
                g3.print();
                boolean result2 = gr3.playGame(g3);
                if (result2 == true){
                    g3.getKeyReward().action(player);
                    player.setKey(g3.getKeyReward());
                    
                    System.out.println("Congratulation, you did it !");
                    System.out.println("Your score is : "+ player.getPoint());
                    input = 1;
                    break;
                }
                
                System.out.println("Press Enter to continue");
                new java.util.Scanner(System.in).nextLine();
                for(int i=0;i<40;i++)
                    System.out.println();
                
            }
            if(player.getPosition().getX() == 4 && player.getPosition().getY() == 0){
                for(int i=0;i<40;i++)
                    System.out.println("\n" );
                
                List listQuestion = new ArrayList<>();
                listQuestion.add(new Question("1+1", "1", "2", "3", "4", "2"));
                listQuestion.add(new Question("2+2", "1", "2", "3", "4", "4"));
                listQuestion.add(new Question("1+2", "1", "2", "3", "4", "3"));
                listQuestion.add(new Question("1+0", "1", "2", "3", "4", "1"));

                Quiz g2 = new Quiz("Question", k1, k2, listQuestion);

                
                String answer = "";
                if(player.getKey().getName().equals(g2.getKeyCondition().getName()))
                    {
                        g2.getQuest();
                        System.out.println("Enter the Answer ...");
                        Scanner scan = new Scanner(System.in);
                        answer = scan.nextLine();
                        
                        for(int i=0;i<40;i++)
                            System.out.println("\n");
                    }
                        
                        GameRunner gr1 = new GameRunner(player.getKey(), answer);

                boolean result = gr1.playGame(g2);
                if (result == true){
                    g2.getKeyReward().action(player);
                    player.setKey(g2.getKeyReward());
                    
                    System.out.println("Congratulation, you won the key for the next level !");
                }
                System.out.println("Press Enter to continue");
                new java.util.Scanner(System.in).nextLine();
                for(int i=0;i<40;i++)
                    System.out.println();
                
            }

            if(player.getPosition().getX() == 9 && player.getPosition().getY() == 2){
                for(int i=0;i<40;i++)
                    System.out.println("\n" );
                
                
                PlusMinusGame g1 = new PlusMinusGame("PlusMinusGame", k2, k3, 59);

                
                String answer = "";
                if(player.getKey().getName().equals(g1.getKeyCondition().getName()))
                    {
                        g1.getQuest();
                        System.out.println("Enter the Answer ...");
                        Scanner scan = new Scanner(System.in);
                        answer = scan.nextLine();
                        
                        for(int i=0;i<40;i++)
                            System.out.println("\n" );
                    }
                        
                        GameRunner gr2 = new GameRunner(player.getKey(), answer);

                boolean result1 = gr2.playGame(g1);
                if (result1 == true){
                    g1.getKeyReward().action(player);
                    player.setKey(g1.getKeyReward());
                    
                    System.out.println("Congratulation, you won the key for the next level !");
                }
                System.out.println("Press Enter to continue");
                new java.util.Scanner(System.in).nextLine();
                for(int i=0;i<40;i++)
                    System.out.println("\n" );
                
            }
            world.print();
           
            
            System.out.println("Health : "+player.getHealthBar().getCurrentPoint());
            world.print();
            System.out.println("Enter the direction ...");
            Scanner sc = new Scanner(System.in);
            String in = sc.nextLine();
            if (in.equals("exit"))
                input = 1;
            if (in.equals("d"))
                player.movePlayer(world, Direction.EAST);
            if (in.equals("z"))
                player.movePlayer(world, Direction.NORTH);
            if (in.equals("s"))
                player.movePlayer(world, Direction.SOUTH);
            if (in.equals("q"))
                player.movePlayer(world, Direction.WEST);
            if (in.equals("k"))
                player.attack(world);
            if (in.equals("i"))
                player.printBag();
            if (in.equals("score")){
                for(int i=0;i<40;i++)
                    System.out.println("\n" );
                System.out.println("Your score is : " + player.getPoint());
                System.out.println("Press Enter to continue");
                new java.util.Scanner(System.in).nextLine();
            }
            if (in.equals("stats")){
                for(int i=0;i<40;i++)
                    System.out.println("\n" );
                player.getStats().print();
                System.out.println("Press Enter to continue");
                new java.util.Scanner(System.in).nextLine();
            }
            if (player.getHealthBar().isDead() == true){
                for(int i=0;i<40;i++)
                    System.out.println("\n" );
                System.out.println("YOU DIED !");
                input = 1;
            }
        }
    }
}
