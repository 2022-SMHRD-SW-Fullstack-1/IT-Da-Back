const formChange = (string) => {
    let newString = '';
    newString += string.substring(7,11);
    const month = string.substring(0, 3)
    if (month === 'Jan')
       newString += '-01-';
    else if (month === 'Feb')
       newString += '-02-';
    else if (month === 'Mar')
       newString += '-03-';
    else if (month === 'Apr')
       newString += '-04-';
    else if (month === 'May')
       newString += '-05-';
    else if (month === 'Jun')
       newString += '-06-';
    else if (month === 'Jul')
       newString += '-07-';
    else if (month === 'Aug')
       newString += '-08-';
    else if (month === 'Sep')
       newString += '-09-';
    else if (month === 'Oct')
       newString += '-10-';
    else if (month === 'Nov')
       newString += '-11-';
    else if (month === 'Dec')
       newString += '-12-';
 
       newString += string.substring(4,5) === '0' ? string.substring(5,6) : string.substring(4,6)
 
       return newString
 }
 
 module.exports = formChange