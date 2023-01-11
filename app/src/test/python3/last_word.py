import unittest


class MyTestCase(unittest.TestCase):
    def test_something(self):
        self.assertEqual(True, True)
    def lengthOfLastWord(self, s: str) -> int:
        arr = list(filter(None, s.split(' ', -1)))
        print(len(arr[len(arr) - 1]))
        print(arr)
        return True
    def test_case1(self):
        t = self.lengthOfLastWord('2 wwe 42 ')
        self.assertTrue(t)



if __name__ == '__main__':
    unittest.main()
