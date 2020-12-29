package Model;
import Entity.Alexandria07103_MonsterEntity;
import java.util.ArrayList;
public class Alexandria07103_MonsterModel implements Alexandria07103_CharacterGameInterfaces{
    private ArrayList <Alexandria07103_MonsterEntity> monsterEntityArrayList;
    public Alexandria07103_MonsterModel (){
        monsterEntityArrayList = new ArrayList <Alexandria07103_MonsterEntity>();
    }
    public void insert (Alexandria07103_MonsterEntity arenaEntity){
        monsterEntityArrayList.add(arenaEntity);
    }
    
    public void setstats(){
        for(Alexandria07103_MonsterEntity monsterEntity : monsterEntityArrayList){
            monsterEntityArrayList.get(0).setHealth(3200);
            monsterEntityArrayList.get(1).setHealth(3470);
            monsterEntityArrayList.get(2).setHealth(4500);
            monsterEntityArrayList.get(3).setHealth(3000);
        }
    }
    
    public Alexandria07103_MonsterEntity showData(int index){
        return monsterEntityArrayList.get(index);
    }
    
    public Alexandria07103_MonsterEntity getMonsteraEntityArrayList(int index){
        return monsterEntityArrayList.get(index);}
}
