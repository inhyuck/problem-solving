/**
 * Date: 2021. 08. 14.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: K번째수
 * description: 배열에서 특정 구간 자르고 k번째 수 구하기.
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/42748
 */

function searchKOrderNumber(array, [i, j, k]) {
    const slicedArray = array.slice(i - 1, j);
    slicedArray.sort((a, b) => a - b);

    return slicedArray[k - 1];
}

function solution(array, commands) {
    return commands.map(command => searchKOrderNumber(array, command));
}

//input
const array = [1, 5, 2, 6, 3, 7, 4];
const commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]];

const result = [5, 6, 3];

//output
function isEqualsArray(arr1, arr2) {
    if (arr1.length !== arr2.length) {
        return false;
    }
    return arr1.every((item, index) => item === arr2[index]);
}

console.log(solution(array, commands));
console.log(isEqualsArray(result, solution(array, commands)));
