public class Worker {

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener{
        void onError(String error);
    }

    private OnTaskErrorListener errorCallback;



    private OnTaskDoneListener callback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start(int error) {
        for (int i = 0; i < 100; i++) {
            if(i == error){
                errorCallback.onError("Error on " + i + " task");
                continue;
            }
            callback.onDone("Task " + i + " is done");
        }
    }
}
