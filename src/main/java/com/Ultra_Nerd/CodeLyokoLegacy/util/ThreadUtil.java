package com.Ultra_Nerd.CodeLyokoLegacy.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public record ThreadUtil() {
    public static final ThreadPoolExecutor SMALL_TASK_THREAD_EXECUTOR = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    public static final ThreadPoolExecutor LARGE_TASK_THREAD_EXECUTOR = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

}
