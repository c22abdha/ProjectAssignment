**The project work was about constructing an app that receives json data to
convert to a type of list.
The work started with creating the necessary classes that were required,
which includes the objects from json, JsonTask, SecondActivity and a RecyclerAdapter.
The objects are Greece, the country name,location and company must be displayed.**


```
 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //button test
        button = findViewById(R.id.sendButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        //initialize necessary components.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerView);
        countries = new ArrayList<>();
        setAdapter();
        new JsonTask(this).execute(JSON_URL);
    }

    private void setAdapter(){
        adapter = new com.example.projectassignment.RecyclerAdapter(countries);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Country>>() {}.getType();
        ArrayList<Country> countries = gson.fromJson(json, type);
        adapter.addCountries(countries);
    }
}
```


```
public class SecondActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("");

            TextView secondTextView = findViewById(R.id.secondTextView);
            secondTextView.setText(name);

        }


    }
}
```


```
class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<Country> countries;

    public RecyclerAdapter(ArrayList<Country> countries){
        this.countries = countries;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView countryText;
        public TextView countryName;

        public MyViewHolder(final View view) {
            super(view);

            countryText = view.findViewById(R.id.countryText);
            countryName = view.findViewById(R.id.countryName);

        }
    }
    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {

        String name = countries.get(position).getName();
        String location = countries.get(position).getLocation();
        String company = countries.get(position).getCompany();
        //  int Size = countries.get(position).getSize();
        // int population = countries.get(position).getPopulation();

        holder.countryText.setText("name: " + name + "\nLocation: " + location + "\nCompany: " + company );
    }

    @Override
    public int getItemCount()
    {
        return countries.size();
    }


    public void addCountries(ArrayList<Country> countries){

        this.countries.addAll(countries);
        notifyDataSetChanged();
    }
}
```



```
public class Country {

    String ID;
    String name;
    int Size;
    String location;
    @SerializedName("cost")
    int population;
    String company;
    String auxdata;


    public Country(String ID, String name,int Size, String location, int population,
                   String company, String auxdata)
    {
        this.ID = ID;
        this.name = name;
        this.Size = Size;
        this.location = location;
        this.population = population;
        this.company = company;
        this.auxdata = auxdata;

    }

    public String ID() {

        return ID;
    }


    public String getName() {

        return name;
    }

    public int getSize() {

        return Size;
    }

    public String getLocation() {

        return location;
    }
    public int getPopulation() {

        return population;
    }



    public String getCompany() {

        return company;
    }

    public String getAuxdata() {

        return auxdata;
    }




}
```

![](Screenshot_20230525_110642.png)
![](Screenshot_20230525_111100.png)
