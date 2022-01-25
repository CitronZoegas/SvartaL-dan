package Box;

public class user_Information {
    private String list;
    private String page;
    user_Information[] _GET =
            new user_Information[]{
                    new user_Information("customers", "2"),
                    new user_Information("customers", "2"),
                    new user_Information("customers", "2"),
                    new user_Information("foo", "bar"),
                    new user_Information("foo", "bar"),
                    new user_Information("foo", "bar")};

    /**
     * This way of creating the information would make the iteration of the "3D multi type array alot easier since
     * we have a common ground, objects.
     *
     * @param list
     * @param page
     */
    public user_Information(String list, String page) {
        this.list = list;
        this.page = page;
    }

    public String getList() {
        return this.list;
    }

    public String getPage() {
        return this.page;
    }

    //
    public user_Information[] iterateArray() {

        for(int i =0; i< _GET.length; i++) {

        }
        return null;
    }
}
