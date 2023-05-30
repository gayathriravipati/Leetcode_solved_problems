class ParkingSystem:

    def __init__(self, big: int, medium: int, small: int):
        #creating an array for the parking spaces
        self.find = [big, medium, small]

    def addCar(self, carType: int) -> bool:
        if self.find[carType-1] > 0:
            self.find[carType-1] -=1
            return True
        else:
            return False


# Your ParkingSystem object will be instantiated and called as such:
# obj = ParkingSystem(big, medium, small)
# param_1 = obj.addCar(carType)