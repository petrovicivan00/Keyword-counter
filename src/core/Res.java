package core;

public class Res {

    public static final String PATH_PROPERTIES = "./src/app.properties";
    public static final String PATH_LOG = "./src/log.txt";

    public static final String ERROR_LOAD_PROPERTIES = "Cannot load properties";
    public static final String ERROR_PARSE_COMMAND = "Cannot parse command";
    public static final String ERROR_ADD_DIRECTORY = "Cannot add directory";
    public static final String ERROR_SCAN_FILE = "Cannot scan file";
    public static final String ERROR_SCAN_WEB = "Cannot scan web page";
    public static final String ERROR_HOP_COUNT = "Hop count property is not a number";
    public static final String ERROR_CORPUS_NOT_FOUND = "Corpus not found";
    public static final String ERROR_CORPUS_NOT_FINISHED = "Calculating corpus not finished";

    public static final String INPUT_COMMAND = "Enter command";

    public static final String INFO_START_THREADS = "Starting threads";
    public static final String INFO_STOP_THREADS = "Stopping threads";
    public static final String INFO_ADD_DIRECTORY = "Adding directory";
    public static final String INFO_SCAN_DIRECTORY = "Scanning directory";
    public static final String INFO_SKIP_PREFIX = "isn't starting with given prefix, skipping";
    public static final String INFO_ADD_WEB = "Add web page";
    public static final String INFO_SCAN_WEB = "Scanning url";
    public static final String INFO_GET_RESULT_SYNC = "Getting result synchronously";
    public static final String INFO_GET_RESULT_ASYNC = "Getting result asynchronously";
    public static final String INFO_CLEAR_SUMMARY_FILE = "Clearing file summary";
    public static final String INFO_CLEAR_SUMMARY_WEB = "Clearing web summary";

    public static final String TITLE_ERROR = "ERROR";
    public static final String TITLE_INFO = "INFO";
    public static final String TITLE_DEBUG = "DEBUG";

    public static final String FORMAT_DATE = "MM/dd/yyyy HH:mm:ss";
    public static final String FORMAT_LOG = "[%s] %s";
    public static final String FORMAT_KEYWORD = " %s ";
    public static final String FORMAT_INPUT = ">>> ";
    public static final String FORMAT_RESULT = "%s: %s";
    public static final String FORMAT_ERROR = "%s: %s";
    public static final String FORMAT_URL = "(?<=href=\")https?://[^\"]*(?=\")";

    public static final String CMD_ADD_DIRECTORY = "ad";
    public static final String CMD_ADD_WEB = "aw";
    public static final String CMD_GET_RESULT_SYNC = "get";
    public static final String CMD_GET_RESULT_ASYNC = "query";
    public static final String CMD_CLEAR_FILE_SUMMARY = "cfs";
    public static final String CMD_CLEAR_WEB_SUMMARY = "cws";
    public static final String CMD_STOP = "stop";
    public static final String CMD_SUMMARY = "summary";

    public static final int CONST_JOB_QUEUE_SIZE = 10;
    public static final int CONST_CPU_CORES_TOTAL = 4;
    public static final int CONST_HASH_PRIME = 31;
}
