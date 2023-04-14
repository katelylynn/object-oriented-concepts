//package org.threads;
//
//public class MultiThreadedBlur {
//
//    PImage img;
//    int threads = 4;
//    int radius = 10;
//    ExecutorService executor;
//
//
//    public void settings() {
//        size(1600, 1067);
//    }
//
//    public void setup() {
//        img = loadImage("image.jpg");
//        img.resize(width, height);
//        image(img, 0, 0);
//        executor = Executors.newFixedThreadPool(threads);
//        noLoop();
//    }
//
//
//
//    public void draw() {
//        loadPixels();
//        int tileSize = width / threads;
//        Thread[] blurThreads = new Thread[threads];
//        // Comment out when told
//        for (int i = 0; i < threads; i++) {
//            int xStart = i * tileSize;
//            int xEnd = xStart + tileSize;
//            blurThreads[i] = new Thread(new BlurTask(xStart, xEnd));
//            blurThreads[i].start();
//        }
//        for (Thread t : blurThreads) {
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        // to here
//
//    /* Comment in when told
//    List<Future<?>> futures = new ArrayList<>();
//    for (int i = 0; i < threads; i++) {
//      int xStart = i * tileSize;
//      int xEnd = xStart + tileSize;
//      Future<?> future = executor.submit(new BlurTask(xStart, xEnd));
//      futures.add(future);
//    }
//    for (Future<?> f : futures) {
//      try {
//        f.get();
//      } catch (InterruptedException | ExecutionException e) {
//        e.printStackTrace();
//      }
//    }
//    */
//        updatePixels();
//    }
//
//
//    class BlurTask implements Runnable {
//        private int startX;
//        private int endX;
//
//        public BlurTask(int startX, int endX) {
//            this.startX = startX;
//            this.endX = endX;
//        }
//
//        public void run() {
//            int sumR, sumG, sumB, count;
//            for (int x = startX; x < endX; x++) {
//                for (int y = 0; y < height; y++) {
//                    sumR = sumG = sumB = count = 0;
//                    for (int dx = -radius; dx <= radius; dx++) {
//                        int xx = x + dx;
//                        if (xx < 0 || xx >= width) {
//                            continue;
//                        }
//                        for (int dy = -radius; dy <= radius; dy++) {
//                            int yy = y + dy;
//                            if (yy < 0 || yy >= height) {
//                                continue;
//                            }
//                            int c = img.pixels[yy * width + xx];
//                            sumR += (c >> 16) & 0xFF;
//                            sumG += (c >> 8) & 0xFF;
//                            sumB += c & 0xFF;
//                            count++;
//                        }
//                    }
//                    int newColor = color(sumR / count, sumG / count, sumB / count);
//                    pixels[y * width + x] = newColor;
//                }
//            }
//        }
//    }
//
//    /**
//     * Main function.
//     *
//     * @param passedArgs arguments from command line
//     */
//    public static void main(String[] passedArgs) {
//        String[] appletArgs = new String[]{"eatBubbles"};
//        MultiThreadedBlur eatBubbles = new MultiThreadedBlur();
//        PApplet.runSketch(appletArgs, eatBubbles);
//    }
//
//}
