package data_strucutures.arrays.implementation

data class DynamicArray(var data: Array<String?> = arrayOfNulls(0)) {
    private var tempData: Array<String?> = arrayOfNulls(0)
    private var count = 0;
    init {
        count = data.size
    }

    fun push(element: String) {
        tempData = data
        count++
        data = Array(count) {
            if (tempData.isEmpty() || it == count-1) element else tempData[it]
        }
    }

    fun get(index: Int): String {
        if (index > count-1) {
            throw IndexOutOfBoundsException()
        }
        return data[index] !!
    }

    fun pop(): String? {
        if (count == 0) {
            throw IndexOutOfBoundsException()
        }
       tempData = data
       data = Array(count-1) {
           tempData[it]
       }
       return tempData[(count--)-1]
    }

    fun remove(index: Int) {
        if (index > count-1) {
            throw IndexOutOfBoundsException()
        }
        tempData = data
        data = Array(count-1) {
            if(it == index && it < count-1) {
                tempData[it+1]
            } else {
                tempData[it]
            }
        }
        count--
    }

    fun insert(index: Int, element: String) {
        if (index > count-1) {
            throw IndexOutOfBoundsException()
        }
        tempData = data
        data = Array(count+1) {
            if(it == index && it < count) {
                element
            } else {
                if( it < index-1) tempData[it] else tempData[it-1]
            }
        }
        count++
    }


}

fun main() {
    val dynamicArray = DynamicArray(arrayOf("Oh"))
    dynamicArray.push("Hi")
    dynamicArray.push("Hello")
    dynamicArray.push("How")
    dynamicArray.push("Hurray")
    dynamicArray.pop()
    dynamicArray.pop()
    println(dynamicArray)
    dynamicArray.remove(1)
    dynamicArray.pop()
    println(dynamicArray)

    dynamicArray.insert(0, "Ho00");

    println(dynamicArray.get(1))
}
