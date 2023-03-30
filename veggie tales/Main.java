import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Main extends JFrame implements ActionListener{
    JTextField input = new JTextField(8);
    JTextArea output = new JTextArea("How many veggies?", 8,15);
    JButton run = new JButton("Run");
    JRadioButton num = new JRadioButton("Enter # of Entries");
    JRadioButton veggies = new JRadioButton("List veggies");
    JRadioButton fruits = new JRadioButton("List fruits");
    JRadioButton sort = new JRadioButton("Sort and merge lists");
    JRadioButton search = new JRadioButton("Search for item");
    ButtonGroup options = new ButtonGroup();
    MergeSort mergeSort = new MergeSort();
    SelectionSort selSort = new SelectionSort();
    BinarySearch binSearch = new BinarySearch();

    String[] veggieArray;
    String[] fruitArray;
    String entry;
    String[] merged;
    String[] mergeSorted;
    enum Phase{
        enter_num,
        enter_fruits,
        enter_veggies,
        sort,
        search;
    };
    enum FruitOrVeg{
        Fruit,
        Veg,
        Done;
    }
    Phase p;
    FruitOrVeg turn = FruitOrVeg.Veg;
    int size;
    int v;
    int f;

    public static void main(String[] args){
        Main frame = new Main();
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public Main(){
        super("Veggie Tales");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(veggies);
        add(fruits);
        add(sort);
        add(search);
        options.add(veggies); //group buttons
        options.add(fruits);
        options.add(sort);
        options.add(search);
        options.add(num);
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(input);
        verticalBox.add(num);
        verticalBox.add(veggies); //arrange buttons vertically
        verticalBox.add(fruits);
        verticalBox.add(sort);
        verticalBox.add(search);
        verticalBox.add(run);
        add(verticalBox);
        add(output);
        output.setEditable(false);
        veggies.addActionListener(this);
        fruits.addActionListener(this);
        search.addActionListener(this);
        sort.addActionListener(this);
        run.addActionListener(this);
        num.addActionListener(this);
        num.setSelected(true);

        // System.out.print("bru");

    }

    public void actionPerformed(ActionEvent event){
        // Object selectedButton = event.getSource();
        Object objSource = event.getSource();
        if (num.isSelected()){
            p = Phase.enter_num;
        }
        else if (veggies.isSelected()){
            output.setText(String.format("Enter %s veggies", veggieArray.length));
            p = Phase.enter_veggies;
        }
        else if (fruits.isSelected()){
            output.setText(String.format("Enter %s fruits", fruitArray.length));
            p = Phase.enter_fruits;
        }
        else if (sort.isSelected()){
            output.setText("Sort and merge arrays");
            p = Phase.sort;
        }
        else if (search.isSelected()){
            output.setText("Search for a veggie/fruit");
            p = Phase.search;
        }

        if (objSource == run){
            entry = input.getText();
            switch(p){ //state machine i think?
                case enter_num:
                    size = Integer.parseInt(entry);
                    if (turn == FruitOrVeg.Veg){
                        veggieArray = new String[size];
                        // System.out.println("this");
                        output.setText("How many fruits?");
                        turn = FruitOrVeg.Fruit;
                    }
                    else if (turn == FruitOrVeg.Fruit){
                        fruitArray = new String[size];
                        merged = new String[veggieArray.length + fruitArray.length];
                        // System.out.println("this works");
                        turn = FruitOrVeg.Done;
                    }
                    break;
                case enter_veggies:
                    if (v < veggieArray.length){
                        veggieArray[v] = entry;
                        v++;
                    }
                    System.out.println(Arrays.toString(veggieArray));
                    break;
                case enter_fruits:
                    if (f < fruitArray.length){
                        fruitArray[f] = entry;
                        f++;
                    }
                    System.out.println(Arrays.toString(fruitArray));
                    break;
                case sort:
                    SelectionSort.main(veggieArray);
                    SelectionSort.main(fruitArray);
                    for (int i = 0; i < veggieArray.length + fruitArray.length; i++){
                        if (i < veggieArray.length){
                            merged[i] = (veggieArray[i]);
                        }
                        else if (i >= veggieArray.length){
                            merged[i] = fruitArray[i - veggieArray.length];
                        }
                    }
                    mergeSort.main(merged);
                    mergeSorted = mergeSort.output();
                    output.setText("Veggies: " + Arrays.toString(veggieArray) + "\n" + "Fruits: " + Arrays.toString(fruitArray) + "\n" +
                    "Merged: " + Arrays.toString(mergeSorted));
                    break;
                case search:
                    binSearch.main(mergeSorted, entry);
                    int result = binSearch.returnResult();
                    if (result == -1){ //if not found
                        output.setText("String not present");
                    }
                    else {
                        output.setText("String found at " + "index " + result);
                    }
                    break;
                default:
                    break;
            }
            input.setText("");
            input.requestFocus();
        }
    }
}
