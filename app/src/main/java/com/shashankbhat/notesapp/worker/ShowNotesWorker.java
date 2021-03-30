package com.shashankbhat.notesapp.worker;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.shashankbhat.notesapp.room.Note;
import com.shashankbhat.notesapp.room.NoteRepository;
import com.shashankbhat.notesapp.notification.NotificationUtil;

public class ShowNotesWorker extends Worker {

    private Context context;

    public ShowNotesWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        NoteRepository repository = new NoteRepository((Application) context);

        if(repository.repoListDateBasedNotes()!=null){
            Note note = repository.repoListDateBasedNotes();
            NotificationUtil.notify(context, note);
            return Result.success();
        }

        return Result.failure();
    }
}
