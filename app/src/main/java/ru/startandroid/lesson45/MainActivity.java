package ru.startandroid.lesson45;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // названия компаний (групп)
    String[] groups = new String[]{"HTC", "Samsung", "LG", "Nokia"};

    // названия телефонов (элементов)
    String[] phonesHTC = new String[]{"Sensation", "Desire", "Wildfire", "Hero", "One"};
    String[] phonesSams = new String[]{"Galaxy S II", "Galaxy Nexus", "Wave", "Galaxsy S7"};
    String[] phonesLG = new String[]{"Optimus", "Optimus Link", "Optimus Black", "Optimus One", "Optimus Glass"};
    String[] phonesNokia = new String[]{"6233", "6234", "7270", "Lumia", "8800"};

    // коллекция для групп
    ArrayList<Map<String, String>> groupData;

    // коллекция для элементов одной группы
    ArrayList<Map<String, String>> childDataItem = new ArrayList<Map<String, String>>();

    // общая коллекция для коллекций элементов
    ArrayList<ArrayList<Map<String, String>>> childData;
    // в итоге получится childData = ArrayList<childDataItem>

    // список атрибутов группы или элемента
    Map<String, String> m;

    ExpandableListView elvMain;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // заполняем коллекцию групп из массива с названиями групп
        groupData = new ArrayList<Map<String, String>>();
        for (String group : groups) {
            // заполняем список атрибутов для каждой группы
            m = new HashMap<String, String>();
            m.put("groupName", group); // имя компании
            groupData.add(m);
        }

        // список атрибутов групп для чтения
        String groupFrom[] = new String[]{"groupName"};
        // список ID view-элементов, в которые будет помещены атрибуты групп
        int groupTo[] = new int[]{android.R.id.text1};


        // создаем коллекцию для коллекций элементов
        childData = new ArrayList<ArrayList<Map<String, String>>>();

        // создаем коллекцию элементов для первой группы
        childDataItem = new ArrayList<Map<String, String>>();
        // заполняем список атрибутов для каждого элемента
        for (String phone : phonesHTC) {
            m = new HashMap<String, String>();
            m.put("phoneName", phone); // название телефона
            childDataItem.add(m);
        }
        // добавляем в коллекцию коллекций
        childData.add(childDataItem);

        // создаем коллекцию элементов для второй группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String phone : phonesSams) {
            m = new HashMap<String, String>();
            m.put("phoneName", phone);
            childDataItem.add(m);
            childData.add(childDataItem);
        }
        // создаем коллекцию элементов для третьей группы
        childDataItem = new ArrayList<Map<String, String>>();
        for (String phone : phonesLG) {
            m = new HashMap<String, String>();
            m.put("phoneName", phone);
            childDataItem.add(m);
        }

            // создаем коллекцию элементов для 4 группы
            childDataItem = new ArrayList<Map<String, String>>();
            for (String phone : phonesNokia) {
                m = new HashMap<String, String>();
                m.put("phoneName", phone);
                childDataItem.add(m);
            }
            childData.add(childDataItem);

            // список атрибутов элементов для чтения
            String childFrom[] = new String[]{"phoneName"};
            // список ID view-элементов, в которые будет помещены атрибуты элементов
            int childTo[] = new int[]{android.R.id.text1};

            SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                    this,
                    groupData,
                    android.R.layout.simple_expandable_list_item_1,
                    groupFrom,
                    groupTo,
                    childData,
                    android.R.layout.simple_list_item_1,
                    childFrom,
                    childTo);

            elvMain = (ExpandableListView) findViewById(R.id.elvMain);
            elvMain.setAdapter(adapter);
        }
    }
