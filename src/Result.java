public class Result {
    public static String layout(String character) {
        // Write your code here
        String check[][] =
                {
                        {"q","w","e","r","t","y","u","i","o","p"},
                        {"a","s","d","f","g","h","j","k","l"},
                        {"z","x","c","v","b","n","m"}
                };
        int a, b;
        for (int i = 0; i<check.length; i++){
            a = i + 1;
            for (int j = 0; j < check[i].length; j++) {
                b = j + 1;
                if(character.equals(check[i][j])){
                    return a +", " + b;
                }
            }
        }
        return null;
    }

}
