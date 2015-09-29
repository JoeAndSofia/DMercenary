package study008_swing.dmercenary.unit;

class LevelUpRule {
	
    private int firstLevel;
    private double coefficient;
    private int regulate;
    private boolean regulateRelateToLevel;
    private int[] levelArr;
    
    public static final LevelUpRule ABILITY_LEVEL_RULE = new LevelUpRule(1,1,0,false,99);
    public static final LevelUpRule SKILL_LEVEL_RULE = new LevelUpRule(10, 1.01, 10, true, 50);
    public static final LevelUpRule CHARACTER_LEVEL_RULE = new LevelUpRule(15, 1.121, 17, true, 100);
    
    public LevelUpRule(int firstLevel, double coefficient, int regulate, boolean regulateRelateToLevel, int maxLevel){
        if (firstLevel <= 0 || coefficient < 0 || maxLevel < 1){
            throw new RuntimeException("Unacceptable argument.");
        }
        this.firstLevel = firstLevel;
        this.coefficient = coefficient;
        this.regulate = regulate;
        this.regulateRelateToLevel = regulateRelateToLevel;
        this.levelArr = new int[maxLevel];
        fillLevelArr();
    }

    private void fillLevelArr(){           //构建等级经验值
        this.levelArr[0] = firstLevel;
        for (int i = 1; i < levelArr.length; i++){
            this.levelArr[i] = (int)(this.levelArr[i - 1] * coefficient + regulate * (regulateRelateToLevel ? i : 1));
        }
    }

    public int maxLevel(){                    //最大等级获取/设定
    	return this.levelArr.length; 
    }
    
    public void maxLevel(int maxLevel){
        if (maxLevel < 1){
            throw new RuntimeException("Unacceptable Argument: level below lower range.");
        }
        this.levelArr = new int[maxLevel];
        fillLevelArr();
    }

    /// <summary>return maximum of experience in the specified level</summary>
    /// <param name="level">specified level</param>
    /// <returns>the maximum of experience in the specified level</returns>
    public int LevelExperience(int level){
        if (level < 0 || level > levelArr.length){
            throw new RuntimeException("Unacceptable Argument: level out of range.");
        }
        if (level == levelArr.length){
            return 0;
        }
        return this.levelArr[level];
    }
}