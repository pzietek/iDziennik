package com.example.idziennik.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {User.class, Subject.class, Grade.class, Klass.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract SubjectDao subjectDao();
    public abstract GradeDao gradeDao();
    public abstract KlassDao klassDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "Database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onCreate (@NonNull SupportSQLiteDatabase db){
                    super.onCreate(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final UserDao userDao;
        private final SubjectDao subjectDao;
        private final GradeDao gradeDao;
        private final KlassDao klassDao;

        PopulateDbAsync(AppDatabase db) {
            userDao = db.userDao();
            subjectDao = db.subjectDao();
            gradeDao = db.gradeDao();
            klassDao = db.klassDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            userDao.deleteAll();
            subjectDao.deleteAll();
            gradeDao.deleteAll();
            klassDao.deleteAll();

            User user = new User(0, "Jan", "Nowak", "student", "student", 's');
            userDao.insert(user);
            user = new User(0, "Marcin", "Kowalski", "student1", "1234", 's');
            userDao.insert(user);
            user = new User(0, "Karolina", "Szymczok", "student2", "7654", 's');
            userDao.insert(user);
            user = new User(0, "Adam", "Sadownik", "student3", "dfghjkuytr", 's');
            userDao.insert(user);

            Subject subject = new Subject(0, "Polski");
            subjectDao.insert(subject);
            subject = new Subject(0, "Angielski");
            subjectDao.insert(subject);
            subject = new Subject(0, "Historia");
            subjectDao.insert(subject);
            subject = new Subject(0, "Biologia");
            subjectDao.insert(subject);
            subject = new Subject(0, "Geografia");
            subjectDao.insert(subject);

            Klass klass = new Klass(0, "I a");
            klassDao.insert(klass);
            klass = new Klass(0, "I b");
            klassDao.insert(klass);
            klass = new Klass(0, "I c");
            klassDao.insert(klass);
            klass = new Klass(0, "II a");
            klassDao.insert(klass);
            klass = new Klass(0, "II b");
            klassDao.insert(klass);
            klass = new Klass(0, "II c");
            klassDao.insert(klass);
            klass = new Klass(0, "III a");
            klassDao.insert(klass);
            klass = new Klass(0, "III b");
            klassDao.insert(klass);
            klass = new Klass(0, "III c");
            klassDao.insert(klass);

            Grade grade = new Grade(0, 4, 1, 1, 's');
            gradeDao.insert(grade);
            grade = new Grade(0, 5, 1, 1, 's');
            gradeDao.insert(grade);
            grade = new Grade(0, 2, 1, 1, 'k');
            gradeDao.insert(grade);
            grade = new Grade(0, 4, 1, 1, 'o');
            gradeDao.insert(grade);
            grade = new Grade(0, 5, 1, 1, 'k');
            gradeDao.insert(grade);
            grade = new Grade(0, 1, 1, 1, 'o');
            gradeDao.insert(grade);
            grade = new Grade(0, 3, 1, 1, 's');
            gradeDao.insert(grade);


            return null;
        }
    }
}

