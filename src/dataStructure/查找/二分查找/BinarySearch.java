package dataStructure.查找.二分查找;

public class BinarySearch {
    private BinarySearch() {
    }

    /*
      二分查找1：标准模版
     */
    public static int binarySearch1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /*                0 1 2 3 4
      二分搜索模版二:  [1 2 3 4 5]
                    left=0,right=5
                    mid=2,num[2]=3,若target=1
     */
    public static int binarySearch2(int[] nums, int target) {
        // 边界判断：数组为空或者数组长度为0
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 起始条件：0,n
        int left = 0, right = nums.length;
        // nums[l,r)，右边成闭区间
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }// 左边界，不变
            else if (nums[mid] < target) {
                left = mid + 1;
            }// 右边边界扩大，右指针不用mid-1
            else if (nums[mid] > target) {
                right = mid;
            }
        }
        // 无条件符合，跳出循环后，需要进行后处理
        // 判断：left不超出数组长度 && nums[left] == target
        if (left != nums.length && nums[left] == target) return left;
        return -1;
    }

    /*
     二分搜索模版三：
    */
    public static int binarySearch3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    /*
      二分查找-递归方式
     */
    public static <E extends Comparable<E>> int binarySearch1(E[] nums, E target) {
        int l = 0, r = nums.length - 1;
        return binarySearch1(nums, l, r, target);
    }

    private static <E extends Comparable<E>> int binarySearch1(E[] nums, int l, int r, E target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid].compareTo(target) == 0) {
            return mid;
        } else if (nums[mid].compareTo(target) > 0) {
            return binarySearch1(nums, l, mid - 1, target);
        } else {
            return binarySearch1(nums, mid + 1, r, target);
        }
    }

    /*
      二分查找-非递归方式
     */
    public static <E extends Comparable<E>> int binarySearch2(E[] nums, E target) {
        int l = 0, r = nums.length - 1;
        // nums[l,r]
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid].compareTo(target) == 0) {
                return mid;
            } else if (nums[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else if (nums[mid].compareTo(target) < 0) {
                l = mid + 1;
            }
        }
        return -1;
    }

    /*
        二分查找变种：upper
        >target的最小值的索引
     */
    private static <E extends Comparable<E>> int upper(E[] nums, E target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else if (nums[mid].compareTo(target) > 0) {
                r = mid;
            }
        }
        return l;
    }

    /*
        二分查找变种：upper_ceil
        ==target，返回最大值索引；否则同upper
     */
    private static <E extends Comparable<E>> int upper_ceil(E[] nums, E target) {
        // upper返回>t的最小值索引
        int u = upper(nums, target);
        // 如果u-1存在且数组的值相同，就返回u-1=t的索引
        if (u - 1 >= 0 && nums[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        // 否则就返回u
        return u;
    }

    /*
      二分查找变种:upper_floor
      ==target，返回最小值索引；否则同upper 等价于 <=target的最大索引
   */
    private static <E extends Comparable<E>> int upper_floor(E[] nums, E target) {
        int l = -1, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            // nums[mid]==target时候，右边可能还有等于的情况，所以l=mid
            if (nums[mid].compareTo(target) <= 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    /*
   二分查找变种：lower
      求<target的最大值索引
   */
    private static <E extends Comparable<E>> int lower(E[] nums, E target) {
        int l = -1, r = nums.length - 1;
        while (l < r) {
            // l和r相邻时候，由于移动得是l=mid，会出现死循环问题
            // 解决问题：r-l+1
            int mid = l + (r - l + 1) / 2;
            if (nums[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    /*
        二分查找变种：lower_ceil
        ==target，返回最大值索引；否则同lower 等价于>=target的最小值索引
    */
    private static <E extends Comparable<E>> int lower_ceil(E[] nums, E target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                // ==的时候，有可能是解，也有可能有相同的解在前面，所以归入到r中
                r = mid;
            }
        }
        return l;
    }

    /*
        二分查找变种:lower_floor
        lower_floor：==target，返回最小值索引；否则同lower
     */
    private static <E extends Comparable<E>> int lower_floor(E[] nums, E target) {
        int l = lower(nums, target);
        if (l + 1 < nums.length && nums[l + 1].compareTo(target) == 0) {
            return l + 1;
        }
        return l;
    }

    /*
        补充：使用>=target的方式实现二分查找
     */
    private static <E extends Comparable<E>> int search(E[] nums, E target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // l是>=target的最小值索引
        if (l < nums.length && nums[l].compareTo(target) == 0) {
            return l;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 1, 3, 3, 5, 5};
        int target = 1;
        int res = lower(nums, target);
        System.out.println("lower:" + res);
    }
}
