
//a que is a linear data structure.New elements join the que from the rear.
// The first element on the que is served first and it goes out.FIFO.
//Most real world applications of ques have ques limited in size.
//Tere are many ways of implemening queues .here we use a fixed size array.
fun main() {
    var q = Queue(5)
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)
//    q.display()
    q.dequeue()
    q.display()



}
//Funcions to implement in ques:
// enque => add from rear
//deque => remove from front
//isFull =>
//isEmpty =>
//peek => see what is at the front
//display() =>List out items currently in queue


class Queue(var capacity:Int){
    var data = IntArray(capacity)
//    we also need to keep track of the rear and front
//    so we initialize pointers that point to the indeces of our array
    var front = 0
    var rear = 0
//    rear should point to the next available slot where we should add value.
    fun enqueue(value:Int){
        if(isFull()){
            println ("Queue is full")
            return
        }
        data[rear] = value
        rear++

    }
//    if que is empty the function return null
    fun dequeue(): Int? {
        if (isEmpty()){
            println("Queue is empty")
            return null
        }
        var removed = data[front]
        for(i in front until rear -1){
            data[i] = data[i+1]
        }
        rear--
        return removed
    }

//obtain element at front
    fun peek(): Int? {
        if (isEmpty()){
            return null
        }

         return data[front]
    }
//    when the front and rear pointer are both pointing to the same index the queue is empty
    fun isEmpty():Boolean{
        return front == rear
    }
// when rear is equal to capacity or size the queue is full
    fun isFull():Boolean{
        return rear == capacity
    }
    fun display() {
        if (isEmpty()){
            return
        }
        for(i in front until rear)
            println(data[i])


    }
}