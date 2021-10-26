package lab3;


public class TowerOfHanoi
{
static void towerOfHanoi(int disk, char source, char dest, char aux)
{
 if (disk == 1)
 {
     System.out.println("Move disk 1 from rod "+source+" to rod "+dest);
     return;
 }
 towerOfHanoi(disk - 1, source, aux, dest);
 System.out.println("Move disk "+ disk + " from rod " +source +" to rod " + dest );
 towerOfHanoi(disk - 1, aux, dest, source);
}


public static void  main(String args[])
{
 int n = 3; 
 towerOfHanoi(n, 'A', 'C', 'B'); 
}
}
