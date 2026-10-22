public class FavoriteThingsArray {
    public static void main(String[] args) {
        String[] favorites = {
            "Music",
            "Food",
            "Travel",
            "Movies",
            "Gaming"
        };

        System.out.println("My Favorite Things:");

        for (int i = 0; i < favorites.length; i++) {
            System.out.println((i + 1) + ". " + favorites[i]);
        }

        System.out.println("Total favorites: " + favorites.length);
    }
}
