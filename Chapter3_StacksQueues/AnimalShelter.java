package Chapter3_StacksQueues;

import java.util.*;

public class AnimalShelter {
    /**
     * CTCI 3.6 Animal Shelter : An animal shelter holds only dogs and cats, and operates on a strictly “first in, first out” basis.
     *                           People must adopt either the “oldest” (based on arrival time) of all animals at the shelter,
     *                           or they can select whether they would the prefer a dog or a cat (and will the receive the oldest
     *                           animal of that type). They cannot select which specific animal they would like.
     *                           Create the data structures to maintain the this system and implement operations
     *                           such as enqueue, dequeueAny, dequeueDog and dequeueCat.
     *                           You may use the built-in Linked List data structure.
     *
     * Approach : Implement a wrapper class AnimalQ which implements the methods enqueue, dequeueAny, dequeueDog and dequeueCat.
     *            The wrapper class AnimalQ uses 2 queues one for dogs and other for cats.
     * Time Complexity - O(1) for all the methods enqueue, dequeueAny, dequeueDog and dequeueCat
     * Space Complexity - O(N) where N is the total number of animals distributed between both the queues.
     * **/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option =0;
        System.out.println("Animal Shelter :: Enter 1 for dog and 2 for cat");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue Any Animal");
        System.out.println("3. Dequeue Cat");
        System.out.println("4. Dequeue Dog");
        System.out.println("5. Print Shelter");
        AnimalQ animalQ = new AnimalQ();
        do {
            System.out.println("Enter your choice");
            option = scanner.nextInt();

            switch (option) {
                case 1: {
                    int animal_type = scanner.nextInt();
                    try {
                        Animal newAnimal = new Animal(animal_type);
                        animalQ.enqueue(newAnimal);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
                case 2:
                    try {
                        Animal oldestAnimal = animalQ.dequeueAny();
                        System.out.println(oldestAnimal.arrivalTime + ","+ oldestAnimal.type);
                    }catch (Exception e){
                            e.printStackTrace();
                    }
                break;
                case 3: try {
                            Animal oldestCat = animalQ.dequeueCat();
                            System.out.println(oldestCat.arrivalTime + ","+ oldestCat.type);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                 break;
                case 4: try {
                            Animal oldestDog = animalQ.dequeueDog();
                            System.out.println(oldestDog.arrivalTime + ","+ oldestDog.type);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                break;
                case 5: animalQ.printQ();
                    break;
            }
        }while(option <= 5);
    }
}

class AnimalQ {
    private static final int DOG = 1;
    private static final int CAT = 2;

    Queue<Animal> dQ;
    Queue<Animal> cQ ;

    AnimalQ() {
        dQ = new LinkedList<>();
        cQ = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        int type = animal.getType();
        switch (type) {
            case DOG:
                dQ.offer(animal);
            break;
            case CAT:
                cQ.offer(animal);
            break;
        }
    }

    public Animal dequeueAny() throws Exception{
        Animal oldestDog = !dQ.isEmpty() ? dQ.peek() : null;
        Animal oldestCat = !cQ.isEmpty() ? cQ.peek() : null;
        if (oldestDog != null && oldestCat != null) {
            if (oldestDog.getArrivalTime() < oldestCat.getArrivalTime()) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        } else {
            if(oldestCat != null) {
                return dequeueCat();
            }
            else if(oldestDog != null) {
                return dequeueDog();
            }else {
                throw new Exception("Empty Shelter!!!!");
            }
        }
    }
    public Animal dequeueCat() throws Exception{
        if(!cQ.isEmpty()) {
            return cQ.poll();
        }else {
            throw new Exception("No cats in the shelter");
        }
    }

    public Animal dequeueDog() throws Exception {
        if((!dQ.isEmpty())) {
            return dQ.poll();
        }else {
            throw new Exception("No dogs in the shelter");
        }
    }

    public void printQ() {
        Iterator ci = cQ.iterator();

        System.out.println("Cat Queue from front to end");
        System.out.println("----------------------------");
        while(ci.hasNext()){
            Animal currentCat = (Animal) ci.next();
            System.out.println("("+currentCat.type+","+currentCat.arrivalTime+")"+"-->");
        }
        System.out.println("NULL\n----------------------------");

        Iterator di = dQ.iterator();
        System.out.println("Dog Queue from front to end");
        System.out.println("----------------------------");
        while(di.hasNext()){
            Animal currentDog = (Animal) di.next();
            System.out.println("("+currentDog.type+","+currentDog.arrivalTime+")"+"-->");
        }
        System.out.println("NULL\n----------------------------");
    }

}

class Animal {
    Long arrivalTime;
    int type; //1 - dog, 2 - cat
    Animal(int atype) throws Exception {
        this.arrivalTime = System.currentTimeMillis();
        if(atype == 1 || atype == 2) {
            this.type = atype;
        }else {
            System.out.println("Invalid Animal Type!!!!");
            throw new Exception("Invalid Animal Type");
        }

    }

    public Long getArrivalTime() {
        return arrivalTime;
    }

    public int getType() {
        return type;
    }
}
