import java.util.Random;
public class Play {
    public static void main(String[] args) {
        Heros link = new Heros("Link", 4000, 50, 200);
        Monster gobelin = new Monster("Gobelin", 500, 50);
        Mage merlin = new Mage("Baba Yaga", 500, 50, 200);
        Boss ganon = new Boss("Mestiefiel", 3000, 400);
        
        int index = 0;
        //boucle random goblin,mage,boss
        while(!link.isKo() && index <= 8) {
            Random r = new Random();        
            index = r.nextInt((10 - 0) + 1) + 0;

            if(index < 5) {
                gobelin.setPv(500);
                System.out.println("A goblin appears with a " + gobelin.weaponShuffle());
                link.weaponChoice();
                while(!gobelin.isKo() && !link.isKo()) {
                    link.attack(gobelin);
                    if(!gobelin.isKo()){
                        gobelin.attackMonster(link);
                    }    
                }
            }
            else if(index >= 5 && index <= 8) {
                merlin.setPv(500);
                System.out.println("A wizard tries to charm you with a " + merlin.weaponShuffle());
                link.weaponChoice();
                while(!merlin.isKo() && !link.isKo()) {
                    link.attack(merlin);
                    if(!merlin.isKo()){
                        merlin.attackMage(link);
                    }    
                }
            }
            else {
                System.out.println("This is the FINAL FIGHT ! BOSS APPEARS with a " + ganon.weaponShuffle() + " !!");
                link.weaponChoice();
                while(!ganon.isKo() && !link.isKo()) {
                    link.attack(ganon);
                    if(!ganon.isKo()){
                        ganon.attackBoss(link);
                    }
                }
            }
        }
        if(!link.isKo()) {
            System.out.println("Congrats, you defeated the Boss, but the princess is in another castle. Try again, noob ! ");
        }
    }
}