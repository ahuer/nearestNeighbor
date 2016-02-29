/**
 * smallworld
 * 
 * As a popular engineer, you know many people in your home city. While traveling around town, visiting your friends,
 * you realize it would be really handy to have a program that tells you which of your friends are closest based
 * upon which friend you are currently visiting.
 * 
 * Being an engineer who is interested in writing software that is useful to everyone, you decide to write a general
 * solution to your quandary. Each of your friends lives at a unique latitude and longitude. For the purposes of this
 * program, the world is flat, and the latitude and longitude are for all intents and purposes Cartesian coordinates
 * on a flat plane. For example, in our flat world, lat 45, long -179 is not as close to lat 45, long 179 when compared
 * to lat 45, long 170.
 * 
 * Write a program that takes a single argument on the command line. This argument must be a file name which contains
 * the input data. Your program should output the nearest three other friends for each friend in the list. You are
 * virtually a celebrity and your friend list can be astoundingly huge; your program must have a running time of faster
 * than O(n2) and be robust and resource efficient.
 * 
 * Output:
 * 1 2,3,4
 * 2 1,3,4
 * 3 1,2,4
 * 4 1,2,3
 * 5 4,3,1
 */