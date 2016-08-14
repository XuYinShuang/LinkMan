package com.zhiyuan3g.linkman.activity;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.zhiyuan3g.linkman.R;
import com.zhiyuan3g.linkman.adapter.LinkManAdapter;
import com.zhiyuan3g.linkman.entity.LinkMans;

import java.util.ArrayList;
import java.util.List;

import static android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
import static android.provider.ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
import static android.provider.ContactsContract.CommonDataKinds.Phone.NUMBER;

public class PhoneActivity extends AppCompatActivity {
    private ListView listView;
    private Context context = this;
    List<LinkMans> linkManses = new ArrayList<>();
    Button btnInsert, btnUpdate, btnDelete;

    //获取库中的phone表字段
    private static final String[] PHONES_PROJECTION = new String[]{
            DISPLAY_NAME, NUMBER};
    ContentResolver resolver = context.getContentResolver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        linkManses = getDate();
        bindAdapter();

    }

    private void initView() {

        listView = (ListView) findViewById(R.id.listView);
        btnDelete= (Button) findViewById(R.id.btnDelete);
        btnInsert= (Button) findViewById(R.id.btnInsert);
        btnUpdate= (Button) findViewById(R.id.btnUpdate);

    }


    private List<LinkMans> getDate() {


        Cursor cursor = resolver.query(CONTENT_URI, PHONES_PROJECTION, null, null, null);


        if (cursor != null) {
            while (cursor.moveToNext()) {
                String number = cursor.getString(cursor.getColumnIndex(NUMBER));
                String name = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));
                LinkMans linkMans = new LinkMans();
                linkMans.setName(name);
                linkMans.setPhone(number);
                linkManses.add(linkMans);
            }
            cursor.close();
        }
        return linkManses;
    }

    private void bindAdapter() {
        LinkManAdapter adapter = new LinkManAdapter(linkManses, context);
        listView.setAdapter(adapter);
    }

//    private void insertPhoneData(String name, String num) {
//
//        ContentValues values = new ContentValues();
//
//        //通过URI得到用户输入的一个值
//        Uri insertData = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, values);
//        //向表中插入值
//        long ID = ContentUris.parseId(insertData);
//
//        //插入姓名
//        if (name != null) {
//            values.clear();
//            values.put(ContactsContract.Data.RAW_CONTACT_ID, ID);
//            values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName
//                    .CONTENT_ITEM_TYPE);
//            values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, name);
//            getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
//
//        }
//        //插入电话
//        if (num != null) {
//            values.clear();
//            values.put(ContactsContract.Data.RAW_CONTACT_ID, ID);
//            values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
//            values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, num);
//            values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone
//                    .TYPE_MOBILE);
//            getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
//
//        }
//
//    }
//
//    private void deletePhoneData(long id) {
//        getContentResolver().delete(ContentUris.withAppendedId(ContactsContract.RawContacts
//                .CONTENT_URI, id), null, null);
//
//
//    }


}






