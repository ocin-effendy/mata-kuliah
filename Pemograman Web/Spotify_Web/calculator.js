const mode = document.querySelector('.mode');
const modeImg = document.querySelector('.mode-img');
const container = document.querySelector('.container');
const operator = document.querySelectorAll('.operator');
const number = document.querySelectorAll('.number');



mode.addEventListener('click', function () {
    if (modeImg.getAttribute('src') === '../assets/contrast.svg') {
        modeImg.src = '../assets/moon.svg';
        container.style.backgroundColor = 'rgb(185, 179, 179)';
    } else {
        modeImg.src = '../assets/contrast.svg';
        container.style.backgroundColor = 'rgb(32, 31, 31)';
    }
})


function getHistory() {
    console.log('ini his : '+ document.getElementById('history-value').innerText);
    return document.getElementById('history-value').innerText;
}

function printHistory(num) {
    document.getElementById('history-value').innerText = num;

}

function getOutput() {
    return document.getElementById('output-value').innerText;
}

function printOutput(num) {
    if (num == '') {
        document.getElementById('output-value').innerText = num;
    } else {
        document.getElementById('output-value').innerText = getFormatedNumber(num);
    }
}

function getFormatedNumber(num) {
    if (num == '-') {
        return '';
    }
    let n = Number(num);
    let value = n.toLocaleString("en");
    return value;
}


function reverseNumberFormat(num) {
    return Number(num.replace(/,/g, ''));
}


printHistory('');
printOutput('');

operator.forEach(o => {
    o.addEventListener('click', function () {
        if (this.id == 'clear') {
            printHistory('');
            printOutput('');
        } else if (this.id == 'back-space') {
            var output = reverseNumberFormat(getOutput()).toString();
            if (output) {
                output = output.substr(0, output.length - 1);
                printOutput(output);
            }
        } else {
            let output = getOutput();
            let history = getHistory();

            if (output == '' && history != '') {
                if (isNaN(history[history.length - 1])) {
                    history = history.substr(0, history.length - 1)
                }
            }

            if (output != '' || history != '') {
                output = output == '' ? output : reverseNumberFormat(output);
                history += output;
                if (this.id == '=') {
                    let result = eval(history);
                    printOutput(result);
                    printHistory('');
                } else {
                    history += this.id;
                    printHistory(history);
                    printOutput('');
                }
            }
        }
    });
})

number.forEach(n => {
    n.addEventListener('click', function () {
        let output = reverseNumberFormat(getOutput());
        if (output != NaN) {
            output += this.id;
            printOutput(output);
        }
    });
})


