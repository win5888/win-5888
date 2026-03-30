const supabase = supabase.createClient('YOUR_SUPABASE_URL', 'YOUR_SUPABASE_KEY');

// Function for User to submit number
async function submitNumber() {
    const num = document.getElementById('user-number').value;
    const { data, error } = await supabase
        .from('predictions')
        .insert([{ user_id: 'User01', number: num }]);
    
    if (error) alert("Error!");
    else alert("Success! Number Saved.");
}

// Function for Admin to update results
async function adminUpdate(m, t, d) {
    await supabase.from('results').insert([{ magnum: m, toto: t, damacai: d }]);
    alert("Results Published!");
}
