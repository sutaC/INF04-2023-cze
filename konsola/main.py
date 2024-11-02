#!/bin/python

# *******************************************************
#  nazwa funkcji: fillArray
#  parametry wejściowe: arr - lista wartości typu logicznego (list[bool])
#  wartość zwracana: None – nic
#  informacje: Wypełnia listę 101 elementami wartości True
#  autor: XYZ
# ****************************************************
def fillArray(arr: list[bool]) -> None:
    for i in range(101):
        arr.append(True)

def calculate(arr: list[bool]) -> None:
    for i in range(2, int(len(arr) ** (1/2))):
        if arr[i]:
            for j in range(i * 2, len(arr), i):
                arr[j] = False

def displayArray(arr: list[bool]) -> None:
    for i in range(2, len(arr)):
        if arr[i]:
            print(i, end=", ")
    print("") 

# Start
array = list[bool]()
fillArray(array)
calculate(array)
print("Liczby pierwsze w zakresie <2, 100>:")
displayArray(array)